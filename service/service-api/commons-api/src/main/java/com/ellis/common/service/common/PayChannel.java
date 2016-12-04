package com.ellis.common.service.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ellis.luo
 * @date 16/11/29 下午4:23
 * @description 支付渠道
 */
public enum PayChannel
{
    ALI_APP_PAY(1, "android支付宝"),
    ALI_IOS_PAY(2, "ios支付宝"),
    ALI_WEB_PAY(3,"网页支付宝"),
    IOS_PAY(4, "ios内购"),
    WEIXIN_APP_PAY(6, "android微信"),
    WEIXIN_IOS_PAY(7, "ios微信"),
    WEIBO_APP_SDK_PAY(8, "android微博sdk"),
    ALI_PC_PAY(10, "pc支付宝"),
    UN_KNOWN(0, "未知");

    private int key;
    private String value;

    private PayChannel(int key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public int getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    private static final Map<Integer, PayChannel> lookup = new HashMap<Integer, PayChannel>();
    static
    {
        for (PayChannel s : EnumSet.allOf(PayChannel.class))
            lookup.put(s.getKey(), s);
    }

    public static PayChannel get(int key)
    {
        return lookup.get(key);
    }

}
