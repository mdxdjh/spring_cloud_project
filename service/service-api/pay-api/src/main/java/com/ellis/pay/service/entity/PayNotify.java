package com.ellis.pay.service.entity;

import com.ellis.common.service.common.PayChannel;
import com.ellis.common.service.entity.BaseModel;

import java.util.Date;
import java.util.Map;

/**
 * 支付回调
 * 
 * @author ellis.luo
 * @date 2016年7月5日 上午10:38:05
 */
public class PayNotify extends BaseModel
{
    private static final long serialVersionUID = 7368119358755465579L;
    /**
     * 支付渠道
     */
    private PayChannel payChannel;

    /**
     * 用户id
     */
    private long uid;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 第三方流水号
     */
    private String tradeNo;

    /**
     * 支付金额
     */
    private long payAmount;

    /**
     * 支付账号
     */
    private String payAcct;

    /**
     * 商家支付账号
     */
    private String busAcct;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付结果,是否成功
     */
    private boolean isSuccess;

    /**
     * 备注
     */
    private String remark;

    /**
     * 支付回调入参
     */
    private Map<String, String> reqParams;

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

    public String getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getTradeNo()
    {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo)
    {
        this.tradeNo = tradeNo;
    }

    public Date getPayTime()
    {
        return payTime;
    }

    public void setPayTime(Date payTime)
    {
        this.payTime = payTime;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getPayAcct()
    {
        return payAcct;
    }

    public void setPayAcct(String payAcct)
    {
        this.payAcct = payAcct;
    }

    public String getBusAcct()
    {
        return busAcct;
    }

    public void setBusAcct(String busAcct)
    {
        this.busAcct = busAcct;
    }

    public PayChannel getPayChannel()
    {
        return payChannel;
    }

    public void setPayChannel(PayChannel payChannel)
    {
        this.payChannel = payChannel;
    }

    public Map<String, String> getReqParams()
    {
        return reqParams;
    }

    public void setReqParams(Map<String, String> reqParams)
    {
        this.reqParams = reqParams;
    }

    public boolean isSuccess()
    {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess)
    {
        this.isSuccess = isSuccess;
    }

}
