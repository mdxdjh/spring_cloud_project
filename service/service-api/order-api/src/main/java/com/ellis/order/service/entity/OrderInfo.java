package com.ellis.order.service.entity;

import com.ellis.common.service.entity.BaseModel;
import com.ellis.pay.service.entity.PayMessage;
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
public class OrderInfo extends BaseModel
{
    private String orderNo;
    private Long uid;
    private Date createTime;
    private Integer orderType;
    private Integer currencyType;
    @DecimalMin("0.0")
    private Long amount;
    private Integer status;
    private Integer goodsId;
    private String goodsName;
    private Integer goodsType;
    private Integer channel;
    private Integer source;
    private Boolean deleted;
    private String receipt;
    private PayMessage payMessage;

    public PayMessage getPayMessage()
    {
        return payMessage;
    }

    public void setPayMessage(PayMessage payMessage)
    {
        this.payMessage = payMessage;
    }

    public String getReceipt()
    {
        return receipt;
    }

    public void setReceipt(String receipt)
    {
        this.receipt = receipt;
    }

    public String getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public Long getUid()
    {
        return uid;
    }

    public void setUid(Long uid)
    {
        this.uid = uid;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Integer getOrderType()
    {
        return orderType;
    }

    public void setOrderType(Integer orderType)
    {
        this.orderType = orderType;
    }

    public Integer getCurrencyType()
    {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType)
    {
        this.currencyType = currencyType;
    }

    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId)
    {
        this.goodsId = goodsId;
    }

    public Integer getGoodsType()
    {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType)
    {
        this.goodsType = goodsType;
    }

    public Integer getChannel()
    {
        return channel;
    }

    public void setChannel(Integer channel)
    {
        this.channel = channel;
    }

    public Integer getSource()
    {
        return source;
    }

    public void setSource(Integer source)
    {
        this.source = source;
    }

    public Boolean getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
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
