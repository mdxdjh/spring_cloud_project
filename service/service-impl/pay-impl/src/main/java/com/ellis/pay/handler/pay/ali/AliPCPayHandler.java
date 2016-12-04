package com.ellis.pay.handler.pay.ali;

import com.alibaba.fastjson.JSON;
import com.ellis.pay.common.PayConfig;
import com.ellis.pay.dal.db.MerAcctInfoPo;
import com.ellis.pay.entity.PayOrder;
import com.ellis.pay.handler.PayHandler;
import com.ellis.pay.service.entity.PayMessage;
import com.ellis.pay.utils.ali.sign.PayUtils;
import com.ellis.pay.utils.ali.sign.RSA;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.ellis.commons.utils.DigitalUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * pc端支付支付宝
 */
@Component("aliPCPayHandler")
public class AliPCPayHandler implements PayHandler
{
    private org.slf4j.Logger Logger = LoggerFactory.getLogger(AliPCPayHandler.class);

    @Override
    public PayMessage getPayMessage(PayOrder payOrder, MerAcctInfoPo acct)
    {

        Map<String, String> temp = new HashMap<String, String>();
        temp.put("service", "create_direct_pay_by_user");// 必填 自我认为应该是支付宝作为判别作为那种服务的标识
        temp.put("partner", acct.getAcctId());
        temp.put("seller_email", acct.getEmail());
        temp.put("_input_charset", PayConfig.encode);
        temp.put("payment_type", "1");
        temp.put("notify_url", PayConfig.aliAppNotifyUrl);
        temp.put("out_trade_no", payOrder.getOrderNo());
        temp.put("subject", payOrder.getGoodsName());
        temp.put("total_fee", DigitalUtil.toYuan2(payOrder.getPayAmount()));
        temp.put("body", payOrder.getGoodsName());

        Map<String, String> params = buildParams(temp, acct.getPrivateKeyPwd(), PayConfig.encode);

        PayMessage payMessage = new PayMessage();
        payMessage.setUrl("https://mapi.alipay.com/gateway.do");
        payMessage.setPayParams(JSON.toJSONString(params));

        Logger.info("获取支付宝APP支付信息 {}", payMessage.getPayParams());
        return payMessage;
    }

    /**
     * 生成要请求给支付宝的参数数组
     * 
     * @param paramTemp
     *        请求前的参数数组
     * @return 要请求的参数数组
     */
    private Map<String, String> buildParams(Map<String, String> paramTemp, String privateKey, String encode)
    {
        // 除去数组中的空值和签名参数
        Map<String, String> params = PayUtils.paraFilter(paramTemp);
        // 生成签名结果
        String prestr = PayUtils.createLinkString(params); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        String sign = RSA.sign(prestr, privateKey, encode);

        // 签名结果与签名方式加入请求提交参数组中
        params.put("sign", sign);
        params.put("sign_type", "RSA");

        return params;
    }
}
