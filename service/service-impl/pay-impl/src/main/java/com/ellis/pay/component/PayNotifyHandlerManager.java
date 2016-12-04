package com.ellis.pay.component;

import com.ellis.common.service.common.PayChannel;
import com.ellis.pay.handler.paynotify.AbstractPayNotifyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付回调处理器管理类
 * 
 * @author ellis.luo
 * @date 2016年6月30日 下午8:48:14
 */
@Component("payNotifyHandlerManager")
public class PayNotifyHandlerManager
{
    private Map<PayChannel, AbstractPayNotifyHandler> payNotifyHandlers;

    @Autowired
    private AbstractPayNotifyHandler aliAppPayNotifyHandler, weiboSDKPayNotifyHandler;

    @PostConstruct
    private void init()
    {
        payNotifyHandlers = new HashMap<PayChannel, AbstractPayNotifyHandler>();
        /** 支付宝支付异步回调 **/
        payNotifyHandlers.put(PayChannel.ALI_APP_PAY, aliAppPayNotifyHandler);
        payNotifyHandlers.put(PayChannel.ALI_IOS_PAY, aliAppPayNotifyHandler);

    }

    public AbstractPayNotifyHandler getPayNotifyHandler(PayChannel payChannel)
    {
        return payNotifyHandlers.get(payChannel);
    }
}
