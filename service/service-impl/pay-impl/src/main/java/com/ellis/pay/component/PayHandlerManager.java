package com.ellis.pay.component;

import com.ellis.common.service.common.PayChannel;
import com.ellis.pay.handler.PayHandler;
import com.ellis.pay.handler.pay.ali.AliWebAppPayHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ellis.luo
 * @date 16/12/1 上午11:10
 * @description 支付器管理类
 */
@Component("payHandlerManager")
public class PayHandlerManager
{
    private Map<PayChannel, PayHandler> payHandlers;

    @Autowired
    private PayHandler aliAppPayHandler, iosPayHandler, aliPCPayHandler, aliWebAppPayHandler;

    @PostConstruct
    private void init()
    {
        payHandlers = new HashMap<PayChannel, PayHandler>();

        /** android支付宝 **/
        payHandlers.put(PayChannel.ALI_APP_PAY, aliAppPayHandler);

        /** ios支付宝 **/
        payHandlers.put(PayChannel.ALI_IOS_PAY, aliAppPayHandler);

        /** 网页支付宝 **/
        payHandlers.put(PayChannel.ALI_WEB_PAY, aliWebAppPayHandler);

        /** pc支付宝 **/
        payHandlers.put(PayChannel.ALI_PC_PAY, aliPCPayHandler);

        /** ios内购 **/
        payHandlers.put(PayChannel.IOS_PAY, iosPayHandler);

    }

    public PayHandler getPayHandler(PayChannel payChannel)
    {
        return payHandlers.get(payChannel);
    }
}
