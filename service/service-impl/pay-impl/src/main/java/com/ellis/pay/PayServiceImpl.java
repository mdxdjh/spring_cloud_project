//package com.ellis.pay;
//
//import com.alibaba.fastjson.JSON;
//import com.ellis.common.service.common.PayChannel;
//import com.ellis.common.service.exception.BusinessException;
//import com.ellis.order.service.OrderService;
//import com.ellis.order.service.entity.OrderInfo;
//import com.ellis.pay.common.PayConfig;
//import com.ellis.pay.component.MerAcctManager;
//import com.ellis.pay.component.PayHandlerManager;
//import com.ellis.pay.component.PayNotifyHandlerManager;
//import com.ellis.pay.dal.db.MerAcctInfoPo;
//import com.ellis.pay.entity.PayOrder;
//import com.ellis.pay.handler.PayHandler;
//import com.ellis.pay.handler.paynotify.AbstractPayNotifyHandler;
//import com.ellis.pay.service.PayService;
//import com.ellis.pay.service.common.ErrorCodeConst;
//import com.ellis.pay.service.entity.PayInfo;
//import com.ellis.pay.service.entity.PayMessage;
//import com.ellis.pay.service.entity.PayNotify;
//import com.ellis.pay.service.exception.PayException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author ellis.luo
// * @date 16/11/20 上午8:18
// * @description
// */
//public class PayServiceImpl implements PayService
//{
//    private Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);
//
//    @Autowired
//    private PayHandlerManager payHandlerManager;
//
//    @Autowired
//    private MerAcctManager merAcctManager;
//
//    @Autowired
//    private PayNotifyHandlerManager payNotifyHandlerManager;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Override
//    public PayMessage toPay(PayInfo payInfo) throws BusinessException
//    {
//        logger.info("支付请求 = {}", JSON.toJSONString(payInfo));
//
//        logger.info("1、获取客户支付渠道信息");
//        MerAcctInfoPo acct = merAcctManager.getMerAcct(PayConfig.merId, payInfo.getPayChannel());
//        if (acct == null)
//        {
//            logger.error("客户支付渠道信息不存在,merId:{}", PayConfig.merId);
//            throw new PayException(ErrorCodeConst.MER_ACCT_CHANNEL_NOT_EXISTS);
//        }
//
//        logger.info("2、装配PayOrder对象 ");
//        PayOrder payOrder = assemble(payInfo);
//
//        logger.info("3、获取支付处理器");
//        PayHandler payHandler = payHandlerManager.getPayHandler(payInfo.getPayChannel());
//        if (null == payHandler)
//        {
//            logger.error("获取支付处理器失败，payChannel:{}", payInfo.getPayChannel().getValue());
//            throw new PayException(ErrorCodeConst.PAY_CHANNEL_ERROR);
//        }
//
//        logger.info("4、根据支付类型获取支付相关信息");
//        PayMessage payMessage = payHandler.getPayMessage(payOrder, acct);
//        if (null == payMessage)
//        {
//            logger.error("获取支付信息失败，payChannel:{}", payInfo.getPayChannel().getValue());
//            throw new PayException(ErrorCodeConst.PAY_CHANNEL_ERROR);
//        }
//
//        postProcessAfterInitialization(payInfo, payMessage, acct); // 后续业务处理,目前只有ios内购
//
//        logger.info("5、去支付结束");
//        return payMessage;
//    }
//
//    @Override
//    public String payNotify(PayNotify payNotify) throws BusinessException
//    {
////        OrderInfo order = orderService.queryOrderInfo(payNotify.getOrderNo());
//        OrderInfo order = null;
//        if (order == null)
//        {
//            logger.error("订单信息为空，orderNo:{}", payNotify.getOrderNo());
//            throw new PayException(ErrorCodeConst.ORDER_IS_NULL);
//        }
//
//        logger.info("1、获取支付回调处理器");
//        AbstractPayNotifyHandler payNotifyHandler = payNotifyHandlerManager
//                .getPayNotifyHandler(PayChannel.get(order.getChannel()));
//        if (null == payNotifyHandler)
//        {
//            logger.error("暂不支持此种支付回调方式，payChannel:{}", PayChannel.get(order.getChannel()));
//            throw new PayException(ErrorCodeConst.GET_PAY_NOTIFY_HANDLER_ERROR);
//        }
//
//        return payNotifyHandler.process(payNotify);
//    }
//
//    private PayOrder assemble(PayInfo payInfo)
//    {
//        PayOrder payOrder = new PayOrder();
//        payOrder.setUid(payInfo.getUid());
//        payOrder.setOrderNo(payInfo.getOrderNo());
//        payOrder.setPayAmount(payInfo.getAmount());
//        payOrder.setReceipt(payInfo.getReceipt());
//        payOrder.setGoodsName(payInfo.getGoodsName());
//
//        return payOrder;
//    }
//
//    private void postProcessAfterInitialization(PayInfo payInfo, PayMessage payMessage, MerAcctInfoPo acct)
//    {
//        // ios内购
//        if (payInfo.getPayChannel().equals(PayChannel.IOS_PAY))
//        {
//            if (payMessage.getPayStatus().equals("0"))
//            {
//                logger.info("4.1、IOS充值成功 orderNo:{}, goodsId:{}", payInfo.getOrderNo(), payInfo.getGoodsId());
//
//            }
//        }
//    }
//
//}
