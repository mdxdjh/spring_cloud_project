package com.ellis.pay.handler.paynotify;

import com.alibaba.fastjson.JSON;
import com.ellis.common.service.common.OrderStatus;
import com.ellis.common.service.common.OrderType;
import com.ellis.common.service.common.PayStatus;
import com.ellis.order.service.OrderService;
import com.ellis.order.service.entity.OrderInfo;
import com.ellis.pay.component.PayManager;
import com.ellis.pay.service.common.ErrorCodeConst;
import com.ellis.pay.service.entity.PayNotify;
import com.ellis.pay.service.exception.PayException;
import com.ellis.commons.lock.RedisReentrantLock;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.ellis.commons.utils.DigitalUtil;
import com.ellis.commons.utils.Pair;

/**
 * 支付回调处理器抽象类
 *
 * @author ellis.luo
 * @date 2016年7月4日 下午3:17:46
 */
public abstract class AbstractPayNotifyHandler
{
    protected org.slf4j.Logger Logger = LoggerFactory.getLogger(getClass());

    private static final String SUCCESS = "success";
    private static final String FAIL = "payfail";

    private static final String LOCK_KEY_PAY_NOTIFY_ORDER = "lock_key_pay_notify_order_";
    private static final Long LOCK_TIMEOUT = 10 * 1000L;

    @Autowired
    @Qualifier(value = "redisReentrantLock")
    private RedisReentrantLock lock;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayManager payManager;

    /** 通用支付回调参数 **/
    private PayNotify payNotify;

    /** 订单信息 **/
    private Pair<Long, OrderInfo> orderPair;

    /**
     * 将第三方返回的结果翻译包装成通用的数据结构
     */
    protected abstract boolean decode();

    /**
     * 校验第三方反馈信息正确性
     */
    protected abstract boolean verifyThird();

    public String process(PayNotify payNotify)
    {
        Logger.info("{} 发起支付回调,orderNo:{}, Message:{}", payNotify.getPayChannel().getValue(), payNotify.getOrderNo(),
                JSON.toJSONString(payNotify));

        this.payNotify = payNotify;

        // 包装数据
        if (!decode())
        {
            Logger.error("{} 包装数据失败 OrderNo:{}", payNotify.getPayChannel().getValue(), payNotify.getOrderNo());
            return FAIL;
        }

        OrderInfo orderInfo = getOrderPair().second;

        try
        {
            Logger.debug("检验支付结果, orderNo:{}, isSuccess:{}", payNotify.getOrderNo(), payNotify.isSuccess());
            if (!payNotify.isSuccess())
            {
                Logger.warn("{} orderNo:{} 回调通知支付不成功!", payNotify.getPayChannel().getValue(), payNotify.getOrderNo());
                return FAIL;
            }

            if (orderInfo.getStatus().equals(OrderStatus.PAY_SUCCESS)
                    || orderInfo.getStatus().equals(OrderStatus.DELIVERED))
            {
                Logger.warn("order:{} 订单已经支付回调", payNotify.getOrderNo());
                return SUCCESS;
            }

            // 签名验证
            if (!verifyThird())
            {
                Logger.error("支付回调反馈信息校验不通过 orderNo:{}", payNotify.getOrderNo());
                return FAIL;
            }

            if (orderInfo.getAmount() != payNotify.getPayAmount())
            {
                Logger.error("{} 支付回调金额异常 OrderNo:{}, orderAmount:{},notifyAmount:{}",
                        payNotify.getPayChannel().getValue(), payNotify.getOrderNo(),
                        DigitalUtil.toYuan2(orderInfo.getAmount()), payNotify.getPayAmount());
                recordErrPayLog(orderInfo, payNotify);
                return FAIL;
            }

            if (!payNotify.getPayAcct().equals(payNotify.getBusAcct()))
            {
                Logger.error("{} 支付商家号异常 OrderNo:{}, payAcct:{},busAmount:{}", payNotify.getPayChannel().getValue(),
                        payNotify.getTradeNo(), payNotify.getPayAcct(), payNotify.getBusAcct());
                recordErrPayLog(orderInfo, payNotify);
                return FAIL;
            }

            // 走MQ
            // orderService.updOrderStatusByOrderNo(payNotify.getOrderNo(), OrderStatus.PAY_SUCCESS);
        }
        finally
        {
            lock.unlock(LOCK_KEY_PAY_NOTIFY_ORDER + payNotify.getOrderNo(), getOrderPair().first);
        }

        Logger.debug("记录流水日志, orderNo:{}", payNotify.getOrderNo());
        recordSuccessPayLog(orderInfo, payNotify);

        // TODO
        // Logger.debug("orderNo:{} 发货", payNotify.getOrderNo());
        // sendReward(orderInfo);

        Logger.info("{} 支付回调结束,orderNo:{}", payNotify.getPayChannel().getValue(), payNotify.getOrderNo());

        return SUCCESS;

    }

    public PayNotify getPayNotify()
    {
        return payNotify;
    }

    public void setPayNotify(PayNotify payNotify)
    {
        this.payNotify = payNotify;
    }

    private void recordErrPayLog(OrderInfo orderInfo, PayNotify payNotify)
    {
        payManager.recordPayLog(PayStatus.PAY_FAIL, OrderType.get(orderInfo.getOrderType()), payNotify);
    }

    private void recordSuccessPayLog(OrderInfo orderInfo, PayNotify payNotify)
    {
        payManager.recordPayLog(PayStatus.PAY_SUCCESS, OrderType.get(orderInfo.getOrderType()), payNotify);
    }

    private long lockOrderByRedis(RedisReentrantLock lock, String orderNo)
    {
        lock.setLockTimeOut(LOCK_TIMEOUT);
        long expireTime = 0L;
        try
        {
            expireTime = lock.lock(LOCK_KEY_PAY_NOTIFY_ORDER + orderNo);
        }
        catch (Throwable e)
        {
            Logger.error("orderNo:{" + orderNo + "} 支付回调订单加锁失败", e);
            expireTime = 0L;
        }
        return expireTime;
    }

    protected Pair<Long, OrderInfo> lockOrderAndGet(String orderNo)
    {
        long expireTime = lockOrderByRedis(lock, orderNo);
        if (expireTime <= 0)
        {
            throw new PayException(ErrorCodeConst.PAY_NOTIFY_ORDER_LOCK_FAIL);
        }

        /** 订单号是否对应 **/
//        OrderInfo orderInfo = orderService.queryOrderInfo(orderNo);
        OrderInfo orderInfo = null;

        return Pair.makePair(expireTime, orderInfo);
    }

    protected OrderInfo getOrder(String orderNo)
    {
        Pair<Long, OrderInfo> p = lockOrderAndGet(orderNo);
        setOrderPair(p);
        return p.second;
    }

    public Pair<Long, OrderInfo> getOrderPair()
    {
        return orderPair;
    }

    public void setOrderPair(Pair<Long, OrderInfo> orderPair)
    {
        this.orderPair = orderPair;
    }

}
