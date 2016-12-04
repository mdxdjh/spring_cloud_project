package com.ellis.common.service.common;

/**
 * @author ellis.luo
 * @date 16/11/29 下午10:59
 * @description
 */

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ellis.luo
 * @date 16/11/29 下午4:23
 * @description 订单状态
 */
public enum OrderStatus
{
    WAIT_DEAL(1, "待处理"), PAY_SUCCESS(2, "支付成功"), PAY_FAIL(3, "支付失败"), DELIVERED(4, "已发货"), REFUNDING(5,
            "退款中"), CANCEL(11, "取消关闭"), EXPIRED(12, "超时关闭"), REFUND(13, "退款关闭");

    private int key;
    private String value;

    private OrderStatus(int key, String value)
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

    private static final Map<Integer, OrderStatus> lookup = new HashMap<Integer, OrderStatus>();
    static
    {
        for (OrderStatus s : EnumSet.allOf(OrderStatus.class))
            lookup.put(s.getKey(), s);
    }

    public static OrderStatus get(int key)
    {
        return lookup.get(key);
    }

}
