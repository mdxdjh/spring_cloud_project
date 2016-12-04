package com.ellis.common.service.common;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ellis.luo
 * @date 16/11/29 下午4:23
 * @description 币种类型
 */
public enum CurrencyType
{
    RMB(1, "人民币"), GOLD(2, "金币"), DIAMOND(3, "钻石");

    private int key;
    private String value;

    private CurrencyType(int key, String value)
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

    private static final Map<Integer, CurrencyType> lookup = new HashMap<Integer, CurrencyType>();
    static
    {
        for (CurrencyType s : EnumSet.allOf(CurrencyType.class))
            lookup.put(s.getKey(), s);
    }

    public static CurrencyType get(int key)
    {
        return lookup.get(key);
    }

}
