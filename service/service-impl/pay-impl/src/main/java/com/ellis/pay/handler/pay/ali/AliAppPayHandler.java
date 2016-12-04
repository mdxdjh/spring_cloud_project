package com.ellis.pay.handler.pay.ali;

import com.ellis.pay.common.PayConfig;
import com.ellis.pay.dal.db.MerAcctInfoPo;
import com.ellis.pay.entity.PayOrder;
import com.ellis.pay.handler.PayHandler;
import com.ellis.pay.service.entity.PayMessage;
import com.ellis.pay.utils.ali.sign.PayUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.ellis.commons.utils.DigitalUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 支付宝 - 移动支付
 * 
 * @author ellis.luo
 * @date 2016年6月30日 下午9:34:12
 */
@Component("aliAppPayHandler")
public class AliAppPayHandler implements PayHandler
{
    private org.slf4j.Logger Logger = LoggerFactory.getLogger(AliAppPayHandler.class);

    @Override
    public PayMessage getPayMessage(PayOrder payOrder, MerAcctInfoPo acct)
    {
        Map<String, String> reqParams = new LinkedHashMap<String, String>();
        reqParams.put("service", "mobile.securitypay.pay");
        reqParams.put("partner", acct.getAcctId());
        reqParams.put("app_id", PayConfig.appId);
        reqParams.put("_input_charset", PayConfig.encode);
        reqParams.put("notify_url", PayConfig.aliAppNotifyUrl);
        reqParams.put("out_trade_no", payOrder.getOrderNo());
        reqParams.put("subject", payOrder.getGoodsName());
        reqParams.put("payment_type", "1");
        reqParams.put("seller_id", acct.getEmail());
        reqParams.put("total_fee", DigitalUtil.toYuan2(payOrder.getPayAmount()));
        reqParams.put("body", payOrder.getGoodsName());
        reqParams.put("sign_type", "RSA");

        String signStr = PayUtils.getSignData(reqParams, true);

        /** 生成支付宝支付签名 **/
        String sign = PayUtils.getAliSign(signStr, acct.getPrivateKeyPwd(), PayConfig.encode);

        reqParams.put("sign", sign);

        PayMessage payMessage = new PayMessage();
        String payParams = getPayParamsStr(reqParams, sign);
        payMessage.setPayParams(payParams);
        payMessage.setUrl(PayConfig.aliAppReqUrl);

        Logger.info("获取支付宝APP支付信息 {}", payMessage.getPayParams());
        return payMessage;
    }

    // 拼接支付结果
    private String getPayParamsStr(Map<String, String> reqParams, String sign)
    {
        StringBuilder payParams = new StringBuilder();
        payParams.append(PayUtils.getSignData(reqParams, true)).append("&sign=\"").append(sign)
                .append("\"&sign_type=\"RSA\"");
        return payParams.toString();
    }

}
