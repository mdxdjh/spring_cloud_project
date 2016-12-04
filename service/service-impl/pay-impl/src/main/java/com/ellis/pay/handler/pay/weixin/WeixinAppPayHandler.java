package com.ellis.pay.handler.pay.weixin;//package com.uxin.zb.pay.handler.pay.weixin;
//
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.uxin.commons.logutil.LogProxy;
//import com.uxin.zb.pay.common.PayConfig;
//import com.uxin.zb.pay.dal.db.MerAcctInfoPo;
//import com.uxin.zb.pay.entity.PayOrder;
//import com.uxin.zb.pay.handler.pay.PayHandler;
//import com.uxin.zb.pay.service.model.PayMessage;
//import com.uxin.zb.pay.util.PayUtils;
//
///**
// * 微信APP支付（Android）
// *
// * @author ellis.luo
// * @date 2016年6月30日 下午9:34:12
// */
//@Component("weixinAppPayHandler")
//public class WeixinAppPayHandler implements PayHandler
//{
//    private Logger Logger = LogProxy.getLogger(WeixinAppPayHandler.class);
//
//    @Autowired
//    private PayConfig config;
//
//    @Override
//    public PayMessage getPayMessage(PayOrder payOrder, MerAcctInfoPo acct)
//    {
//        // 微信app支付请求处理器
//        WeixinAppReqHandler reqHandler = new WeixinAppReqHandler(payOrder, acct);
//
//        // 微信预支付
//        Map<String, String> result = reqHandler.prePay();
//
//        PayMessage payMessage = new PayMessage();
//
//        // 预支付通讯成功
//        if (result.get("return_code").equals("SUCCESS"))
//        {
//            // 预支付成功
//            if (result.get("return_code").equals("SUCCESS"))
//            {
//                // 获取prepay_id
//                String prepayId = result.get("prepay_id");
//
//                // 生成微信支付签名
//                Map<String, String> reqParams = reqHandler.getSign(prepayId);
//
//                String payParams = PayUtils.getPayParams(reqParams);
//                payMessage.setPayParams(payParams);
//                payMessage.setUrl(config.getWeixinAppReqUrl());
//
//            }
//            else // 预支付失败
//            {
//                Logger.error("微信App预支付失败, orderNo:{} err_code_des:{}", payOrder.getOrderNo(),
//                        result.get("err_code_des"));
//            }
//        }
//        else
//        {
//            Logger.error("微信App预支付通讯失败, orderNo:{} return_msg:{}", payOrder.getOrderNo(), result.get("return_msg"));
//        }
//
//        return payMessage;
//    }
//
//    public static void main(String[] args)
//    {
//        System.out.println(System.currentTimeMillis() / 1000);
//    }
//}
