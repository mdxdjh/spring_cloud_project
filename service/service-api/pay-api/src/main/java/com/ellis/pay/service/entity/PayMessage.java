package com.ellis.pay.service.entity;

import java.io.Serializable;

/**
 * @author ellis.luo
 * @date 16/12/1 上午12:50
 * @description
 */
public class PayMessage implements Serializable
{
    private static final long serialVersionUID = -3854546612284158401L;

    /**
     * 支付状态
     */
    private String payStatus;
    /**
     * 第三方请求支付url
     */
    private String url;
    /**
     * 请求支付参数
     */
    private String payParams;

    public String getPayParams()
    {
        return payParams;
    }

    public void setPayParams(String payParams)
    {
        this.payParams = payParams;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getPayStatus()
    {
        return payStatus;
    }

    public void setPayStatus(String payStatus)
    {
        this.payStatus = payStatus;
    }

}
