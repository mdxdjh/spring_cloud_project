package com.ellis.pay.handler.pay.ios;

import com.alibaba.fastjson.JSON;
import com.ellis.common.service.common.PayChannel;
import com.ellis.common.service.common.PayStatus;
import com.ellis.pay.common.PayConfig;
import com.ellis.pay.component.PayManager;
import com.ellis.pay.dal.db.IphonePayLogPo;
import com.ellis.pay.dal.db.MerAcctInfoPo;
import com.ellis.pay.entity.PayOrder;
import com.ellis.pay.handler.PayHandler;
import com.ellis.pay.component.MerAcctManager;
import com.ellis.pay.service.common.ErrorCodeConst;
import com.ellis.pay.service.entity.PayMessage;
import com.ellis.pay.service.exception.PayException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ellis.commons.crypto.MD5Coding;
import com.ellis.commons.lock.RedisReentrantLock;
import com.ellis.commons.net.HttpInvokeUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.ellis.commons.serializer.JsonSerializer;

import java.util.Date;

/***
 * ios内购
 * 
 * @author ellis.luo
 * @date 2016年7月9日 下午12:42:17
 */
@Component("iosPayHandler")
public class IOSPayHandler implements PayHandler
{
    private org.slf4j.Logger Logger = LoggerFactory.getLogger(IOSPayHandler.class);

    private static final String LOCK_KEY_IOS_PAY_NOTIFY_ORDER = "lock_key_ios_pay_notify_unique_no_";
    private static final Long LOCK_TIMEOUT = 10 * 1000L;

    @Autowired
    private PayManager payManager;

    @Autowired
    private MerAcctManager merAcctManager;

    @Autowired
    @Qualifier(value = "redisReentrantLock")
    private RedisReentrantLock lock;

    @Override
    public PayMessage getPayMessage(PayOrder payOrder, MerAcctInfoPo acct)
    {
        PayMessage payMessage = new PayMessage();

        String uniqueNo = MD5Coding.encodeForWx(payOrder.getReceipt().toString());

        long expireTime = lockReceiptByRedis(lock, uniqueNo);
        Logger.info("uniqueNo:{}, expireTime:{}", uniqueNo, expireTime);
        if (expireTime <= 0)
        {
            throw new PayException(ErrorCodeConst.PAY_NOTIFY_ORDER_LOCK_FAIL);
        }

        try
        {
            // 幂等性校验
            IphonePayLogPo log = payManager.queryIphonePayLogByReceipt(payOrder.getReceipt());
            if (log == null)
            {
                // 校验收据
                String payStatus = checkReceipt(payOrder);
                payMessage.setPayStatus(payStatus);
                addIosPayLog(payOrder, payStatus);
            }
            else
            {
                Logger.warn("IOS收据已校验");
                // 已经校验过收据的支付状态设置成-1
                payMessage.setPayStatus("-1");
            }
        }
        finally
        {
            Logger.info("unlock : {}", LOCK_KEY_IOS_PAY_NOTIFY_ORDER + uniqueNo);
            lock.unlock(LOCK_KEY_IOS_PAY_NOTIFY_ORDER + uniqueNo, expireTime);
        }

        Logger.info("获取IOS支付信息 {}", JSON.toJSONString(payOrder));
        return payMessage;
    }

    private void addIosPayLog(PayOrder payOrder, String payStatus)
    {
        MerAcctInfoPo acct = merAcctManager.getMerAcct(PayConfig.merId, PayChannel.IOS_PAY);

        IphonePayLogPo log = new IphonePayLogPo();
        log.setPayAcct(acct.getAcctId());
        log.setPayAmount(payOrder.getPayAmount());
        log.setOrderNo(payOrder.getOrderNo());
        if (payStatus.equals("0"))
        {
            log.setPayStatus(PayStatus.PAY_SUCCESS.getKey() + "");
        }
        else
        {
            log.setPayStatus(PayStatus.PAY_FAIL.getKey() + "");
        }
        log.setPayTime(new Date());
        log.setReceipt(payOrder.getReceipt());
        log.setUid(payOrder.getUid());
        log.setRemark(payStatus);

        payManager.addIosPayLog(log);
    }

    private String checkReceipt(PayOrder payOrder)
    {
        String receipt = payOrder.getReceipt();
        String text = "{\"receipt-data\": \"" + receipt + "\"}";

        String str = HttpInvokeUtil.httpPost(PayConfig.iosVerifyUrl, text, PayConfig.encode);
        JsonNode result = JsonSerializer.parse(str, JsonNode.class);
        Logger.debug("ios verify result:{}", JSON.toJSONString(result));

        String payStatus = "";
        if (result != null)
        {
            payStatus = result.get("status").toString();
            if (payStatus.equals("21007"))
            {
                String sandBoxStr = HttpInvokeUtil.httpPost(PayConfig.iosSandboxVerifyUrl, text, PayConfig.encode);
                JsonNode sandBoxResult = JsonSerializer.parse(sandBoxStr, JsonNode.class);
                Logger.debug("ios sandbox verify result:{}", JSON.toJSONString(sandBoxResult));
                payStatus = sandBoxResult.get("status").toString();
            }
        }
        else
        {
            Logger.error("IOS支付验证返回空值");
        }

        return payStatus;
    }

    private long lockReceiptByRedis(RedisReentrantLock lock, String uniqueNo)
    {
        lock.setLockTimeOut(LOCK_TIMEOUT);
        long expireTime = 0L;
        try
        {
            expireTime = lock.lock(LOCK_KEY_IOS_PAY_NOTIFY_ORDER + uniqueNo);
        }
        catch (Throwable e)
        {
            Logger.error("uniqueNo:{" + uniqueNo + "} ios内购回调订单加锁失败", e);
            expireTime = 0L;
        }
        return expireTime;
    }
}
