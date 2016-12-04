package com.ellis.pay.entity;

/**
 * @author ellis.luo
 * @date 16/12/1 上午12:51
 * @description
 */
public class PayOrder
{
    private long uid; // uid
    private String orderNo; // 订单号
    private long payAmount; // 支付金额(分)
    private String goodsName; // 商品名称
    private String receipt; // 收据

    public String getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public long getPayAmount()
    {
        return payAmount;
    }

    public void setPayAmount(long payAmount)
    {
        this.payAmount = payAmount;
    }

    public long getUid()
    {
        return uid;
    }

    public void setUid(long uid)
    {
        this.uid = uid;
    }

    public String getReceipt()
    {
        return receipt;
    }

    public void setReceipt(String receipt)
    {
        this.receipt = receipt;
    }

}
