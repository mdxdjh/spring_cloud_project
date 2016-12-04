package com.ellis.common.service.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ellis.luo
 * @date 16/11/29 下午4:23
 * @description 订单来源
 */
public enum OrderSource
{
    IOS(1, "ios"), ANDROID(2, "android"), PC(3, "pc"), UN_KNOWN(0, "未知");

    private int key;
    private String value;

    private OrderSource(int key, String value)
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

    private static final Map<Integer, OrderSource> lookup = new HashMap<Integer, OrderSource>();
    static
    {
        for (OrderSource s : EnumSet.allOf(OrderSource.class))
            lookup.put(s.getKey(), s);
    }

    public static OrderSource get(int key)
    {
        return lookup.get(key);
    }

}
