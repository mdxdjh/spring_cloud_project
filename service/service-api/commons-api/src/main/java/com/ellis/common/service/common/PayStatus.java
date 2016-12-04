package com.ellis.common.service.common;

/**
 * 支付状态
 */
public enum PayStatus
{
    WAIT_DEAL(1, "待处理"), PAY_SUCCESS(2, "完成支付"), PAY_FAIL(3, "支付失败"), CANCEL(11, "取消关闭"), EXPIRED(12,
            "超时关闭"), REFUND(13, "退款关闭");

    private int key;
    private String value;

    private PayStatus(int key, String value)
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

}
