package com.ellis.pay.handler.pay.weixin;//package com.uxin.zb.pay.handler.pay.weixin;
//
//import java.util.Map;
//import java.util.TreeMap;
//
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.uxin.zb.biz.commons.model.PayChannel;
//import com.uxin.commons.logutil.LogProxy;
//import com.uxin.commons.com.ellis.commons.crypto.net.http.HttpInvokeUtil;
//import com.uxin.commons.util.DateUtil;
//import com.uxin.commons.util.DigitalUtil;
//import com.uxin.zb.pay.common.PayConfig;
//import com.uxin.zb.pay.component.MerAcctManager;
//import com.uxin.zb.pay.dal.db.MerAcctInfoPo;
//import com.uxin.zb.pay.entity.PayOrder;
//import com.uxin.zb.pay.util.PayUtils;
//
///**
// * 微信app支付请求处理器
// *
// * @author ellis.luo
// * @date 2016年7月7日 下午11:35:20
// */
//public class WeixinAppReqHandler
//{
//    private Logger Logger = LogProxy.getLogger(WeixinAppReqHandler.class);
//
//    @Autowired
//    private PayConfig config;
//
//    private PayOrder payOrder;
//
//    private MerAcctInfoPo acct;
//
//    @Autowired
//    private MerAcctManager merAcctManager;
//
//    public WeixinAppReqHandler(PayOrder payOrder, MerAcctInfoPo acct)
//    {
//        this.payOrder = payOrder;
//        this.acct = acct;
//    }
//
//    /** 预支付 **/
//    public Map<String, String> prePay()
//    {
//        acct = merAcctManager.getMerAcct(config.getMerId(), PayChannel.WEIXIN_APP_PAY);
//
//        Map<String, String> preReqParams = new TreeMap<String, String>();
//        preReqParams.put("appid", config.getAppId());
//        preReqParams.put("mch_id", acct.getAcctId());
//        preReqParams.put("nonce_str", PayUtils.getNonceStr()); // 生成32位的随机字符串
//        preReqParams.put("body", payOrder.getGoodsName());
//        preReqParams.put("out_trade_no", payOrder.getOrderNo());
//        preReqParams.put("total_fee", DigitalUtil.toYuan2(payOrder.getPayAmount()));
//        preReqParams.put("spbill_create_ip", config.getWeixinAppPayIp());
//        preReqParams.put("notify_url", config.getWeixinAppNotifyUrl());
//        preReqParams.put("trade_type", "APP");
//
//        // 生成微信预支付签名
//        String preSign = PayUtils.getWeixinSign(preReqParams, acct.getSignKey());
//        Logger.info("微信生成预支付签名,sign:{}", preSign);
//        preReqParams.put("sign", preSign);
//
//        // 获取预支付prepay_id
//        String postText = getPostText(preReqParams);
//        String rsp = HttpInvokeUtil.httpPost(config.getWeixinAppReqUrl(), postText, config.getEncode());
//        Map<String, String> result = PayUtils.parseXml(rsp);
//
//        return result;
//    }
//
//    /** 生成微信支付签名 **/
//    public Map<String, String> getSign(String prepay_id)
//    {
//        Map<String, String> reqParams = new TreeMap<String, String>();
//        reqParams.put("appid", config.getAppId());
//        reqParams.put("partnerid", acct.getAcctId());
//        reqParams.put("prepayid", prepay_id);
//        reqParams.put("package", PayUtils.getNonceStr());// 生成32位的随机字符串
//        reqParams.put("noncestr", "Sign=WXPay");
//        reqParams.put("timestamp", DateUtil.getTimestamp());
//        // 生成微信支付签名
//        String sign = PayUtils.getWeixinSign(reqParams, acct.getSignKey());
//        Logger.info("微信生成支付签名,sign:{}", sign);
//        reqParams.put("sign", sign);
//
//        return reqParams;
//    }
//
//    // 获取微信预支付请求的PostText
//    private String getPostText(Map<String, String> reqParams)
//    {
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("<xml>");
//        if (reqParams != null && !reqParams.isEmpty())
//        {
//            for (Map.Entry<String, String> entry : reqParams.entrySet())
//            {
//                if (entry.getKey().equals("attach") || entry.getKey().equals("body") || entry.getKey().equals("sign"))
//                {
//                    buffer.append("<" + entry.getKey() + ">");
//                    buffer.append("<![CDATA[" + entry.getValue() + "]]>");
//                    buffer.append("</" + entry.getKey() + ">");
//                }
//                else
//                {
//                    buffer.append("<" + entry.getKey() + ">");
//                    buffer.append(entry.getValue());
//                    buffer.append("</" + entry.getKey() + ">");
//                }
//            }
//        }
//        buffer.append("</xml>");
//
//        return buffer.toString();
//    }
//
//}
