package com.ellis.pay.handler.paynotify.impl;

import com.ellis.common.service.common.PayChannel;
import com.ellis.order.service.entity.OrderInfo;
import com.ellis.pay.common.PayConfig;
import com.ellis.pay.dal.db.MerAcctInfoPo;
import com.ellis.pay.handler.paynotify.AbstractPayNotifyHandler;
import com.ellis.pay.component.MerAcctManager;
import com.ellis.pay.service.entity.PayNotify;
import com.ellis.pay.utils.ali.sign.PayUtils;
import com.ellis.pay.utils.ali.sign.RSA;
import com.ellis.commons.net.HttpInvokeUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ellis.commons.utils.DateUtil;
import com.ellis.commons.utils.DigitalUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 移动支付－支付宝异步回调
 *
 * @author ellis.luo
 * @date 2016年7月4日 下午3:18:04
 */
@Component("aliAppPayNotifyHandler")
public class AliAppPayNotifyHandler extends AbstractPayNotifyHandler
{
    private org.slf4j.Logger Logger = LoggerFactory.getLogger(AliAppPayNotifyHandler.class);

    @Autowired
    private MerAcctManager merAcctManager;

    /** 第三方回调参数 **/
    private PayNotify thirdPayNotify;
    /** 第三放账号信息 **/
    private MerAcctInfoPo acct;

    private static final List<String> TRADE_SUCCESS = new ArrayList<String>(2);
    static
    {
        TRADE_SUCCESS.add("TRADE_FINISHED");
        TRADE_SUCCESS.add("TRADE_SUCCESS");
    }

    @Override
    protected boolean decode()
    {
        thirdPayNotify = getPayNotify();

        String orderNo = thirdPayNotify.getReqParams().get("out_trade_no");

        Logger.debug("支付回调订单是否存在, orderNo:{}", orderNo);
        OrderInfo orderInfo = getOrder(orderNo);
        if (null == orderInfo)
        {
            return false;
        }

        PayChannel payChannel = PayChannel.ALI_APP_PAY;

        // 支付账户信息
        acct = merAcctManager.getMerAcct(PayConfig.merId, payChannel);

        thirdPayNotify.setOrderNo(orderNo);
        thirdPayNotify.setPayAcct(acct.getAcctId());
        thirdPayNotify.setPayChannel(payChannel);
        thirdPayNotify.setUid(orderInfo.getUid());
        thirdPayNotify.setBusAcct(thirdPayNotify.getReqParams().get("seller_id"));
        thirdPayNotify.setRemark(thirdPayNotify.getReqParams().get("trade_status"));
        thirdPayNotify.setPayAmount(DigitalUtil.toFen(thirdPayNotify.getReqParams().get("total_fee")));
        thirdPayNotify.setTradeNo(thirdPayNotify.getReqParams().get("trade_no"));
        if (thirdPayNotify.getReqParams().get("gmt_payment") != null)
        {
            thirdPayNotify.setPayTime(DateUtil.parseTime(thirdPayNotify.getReqParams().get("gmt_payment")));
        }
        thirdPayNotify.setSuccess(TRADE_SUCCESS.contains(thirdPayNotify.getReqParams().get("trade_status")));

        return true;
    }

    private boolean verifySign()
    {
        boolean verified = false;
        String verifyData = getVerifyData();
        String publicKey = acct.getPublicKeyPwd();
        verified = RSA.verify(verifyData, thirdPayNotify.getReqParams().get("sign"), publicKey, PayConfig.encode);

        return verified;
    }

    private boolean verifyNotify()
    {
        // 获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
        Map<String, String> paramMap = new LinkedHashMap<String, String>();
        paramMap.put("partner", thirdPayNotify.getReqParams().get("seller_id"));
        paramMap.put("notify_id", thirdPayNotify.getReqParams().get("notify_id"));
        String rsp = HttpInvokeUtil.httpGet(PayConfig.aliAppVerifyUrl, paramMap);
        return rsp.equals("true");
    }

    private String getVerifyData()
    {
        Map<String, String> params = thirdPayNotify.getReqParams();

        String sign = PayUtils.getSignData(params, false);
        // sign = sign.replace("\"", ""); // 异步回调待签名字符串没有"号
        return sign;
    }

    @Override
    protected boolean verifyThird()
    {
        boolean verifySignResult = verifySign();
        boolean verifyNotifyResult = verifyNotify();

        Logger.info("第三方校验结果 verifySignResult:{}, verifyNotifyResult:{}", verifySignResult, verifyNotifyResult);
        return verifySignResult & verifyNotifyResult;
    }

}
