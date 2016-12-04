package com.ellis.pay.service.entity;

import com.ellis.common.service.common.CurrencyType;
import com.ellis.common.service.common.OrderSource;
import com.ellis.common.service.common.OrderType;
import com.ellis.common.service.common.PayChannel;
import com.ellis.common.service.entity.BaseModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @author ellis.luo
 * @date 16/11/20 下午2:12
 * @description
 */
public class PayInfo extends BaseModel
{
    // uid
    private Long uid;
    // 订单号
    private String orderNo;
    // 订单类型
    private OrderType orderType;
    // 货币类型
    private CurrencyType currencyType;
    // 商品id
    private long goodsId;
    // 问题id
    private long questionId;
    // 订单来源
    private OrderSource source;
    // 支付渠道
    private PayChannel payChannel;
    // 支付金额(分)
    private Long amount;
    // 收据
    private String receipt;
    // 商品名称
    private String goodsName;

    public Long getUid()
    {
        return uid;
    }

    public void setUid(Long uid)
    {
        this.uid = uid;
    }

    public String getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public OrderType getOrderType()
    {
        return orderType;
    }

    public void setOrderType(OrderType orderType)
    {
        this.orderType = orderType;
    }

    public CurrencyType getCurrencyType()
    {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType)
    {
        this.currencyType = currencyType;
    }

    public long getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(long goodsId)
    {
        this.goodsId = goodsId;
    }

    public long getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(long questionId)
    {
        this.questionId = questionId;
    }

    public OrderSource getSource()
    {
        return source;
    }

    public void setSource(OrderSource source)
    {
        this.source = source;
    }

    public PayChannel getPayChannel()
    {
        return payChannel;
    }

    public void setPayChannel(PayChannel payChannel)
    {
        this.payChannel = payChannel;
    }

    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public String getReceipt()
    {
        return receipt;
    }

    public void setReceipt(String receipt)
    {
        this.receipt = receipt;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }
}
