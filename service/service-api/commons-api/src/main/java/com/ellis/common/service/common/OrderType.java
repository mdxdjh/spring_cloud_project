package com.ellis.common.service.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ellis.luo
 * @date 16/11/29 下午4:23
 * @description 订单类型
 */
public enum OrderType
{
    RECHARGE_ORDER(1, "充值订单"), UN_KNOWN(0, "未知");

    private int key;
    private String value;

    private OrderType(int key, String value)
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

    private static final Map<Integer, OrderType> lookup = new HashMap<Integer, OrderType>();
    static
    {
        for (OrderType s : EnumSet.allOf(OrderType.class))
            lookup.put(s.getKey(), s);
    }

    public static OrderType get(int key)
    {
        return lookup.get(key);
    }

}
