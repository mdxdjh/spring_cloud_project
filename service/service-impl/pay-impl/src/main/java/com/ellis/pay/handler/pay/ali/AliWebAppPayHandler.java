//package com.ellis.pay.handler.pay.ali;
//
//import com.alibaba.fastjson.JSON;
//import com.ellis.commons.utils.DateUtil;
//import com.ellis.commons.utils.DigitalUtil;
//import com.ellis.pay.common.PayConfig;
//import com.ellis.pay.dal.db.MerAcctInfoPo;
//import com.ellis.pay.entity.PayOrder;
//import com.ellis.pay.handler.PayHandler;
//import com.ellis.pay.service.entity.PayMessage;
//import com.ellis.pay.utils.ali.sign.PayUtils;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * 支付宝 - 网页支付
// *
// * @author ellis.luo
// * @date 2016年6月30日 下午9:34:12
// */
//@Component("aliWebAppPayHandler")
//public class AliWebAppPayHandler implements PayHandler
//{
//    private org.slf4j.Logger Logger = LoggerFactory.getLogger(AliWebAppPayHandler.class);
//
//    @Override
//    public PayMessage getPayMessage(PayOrder payOrder, MerAcctInfoPo acct)
//    {
//        Map<String, String> reqParams = new LinkedHashMap<String, String>();
//        reqParams.put("app_id", PayConfig.appId);
//        reqParams.put("method", "alipay.trade.wap.pay");
//        reqParams.put("charset", PayConfig.encode);
//        reqParams.put("timestamp", DateUtil.formatTime(new Date()));
//        reqParams.put("version","1.0");
//        reqParams.put("notify_url", PayConfig.aliAppNotifyUrl);
//
//        Map<String,String> bizMap = new HashMap<String,String>();
//        bizMap.put("subject",payOrder.getGoodsName());
//        bizMap.put("out_trade_no", payOrder.getOrderNo());
//        bizMap.put("total_amount",DigitalUtil.toYuan2(payOrder.getPayAmount()));
//        bizMap.put("product_code","QUICK_WAP_PAY");
//        bizMap.put("sign_type","RSA");
//
//        String bizContent = JSON.toJSONString(bizMap);
//        reqParams.put("biz_content",bizContent);
//
//        String signStr = PayUtils.getWebSignData(reqParams, true);
//
//        /** 生成支付宝支付签名 **/
//        String sign = PayUtils.getAliSign(signStr, acct.getPrivateKeyPwd(), PayConfig.encode);
//
//        reqParams.put("sign", sign);
//
//        PayMessage payMessage = new PayMessage();
//        String payParams = getPayParamsStr(reqParams, sign);
//        payMessage.setPayParams(payParams);
//        payMessage.setUrl(PayConfig.aliAppReqUrl);
//
//        Logger.info("获取支付宝网页支付信息 {}", payMessage.getPayParams());
//        return payMessage;
//    }
//
//    // 拼接支付结果
//    private String getPayParamsStr(Map<String, String> reqParams, String sign)
//    {
//        StringBuilder payParams = new StringBuilder();
//        payParams.append(PayUtils.getSignData(reqParams, true)).append("&sign=\"").append(sign)
//                .append("\"&sign_type=\"RSA\"");
//        return payParams.toString();
//    }
//
//}
