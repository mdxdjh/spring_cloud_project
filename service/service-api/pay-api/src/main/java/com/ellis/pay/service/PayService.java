package com.ellis.pay.service;

import com.ellis.common.service.exception.BusinessException;
import com.ellis.pay.service.entity.PayInfo;
import com.ellis.pay.service.entity.PayMessage;
import com.ellis.pay.service.entity.PayNotify;
import com.ellis.pay.service.exception.PayException;

/**
 * @author ellis.luo
 * @date 16/11/19 下午10:40
 * @description
 */
public interface PayService
{
    /**
     * 去支付
     * 
     * @param orderInfo
     * @throws PayException
     */
    public PayMessage toPay(PayInfo orderInfo) throws BusinessException;

    /**
     * 支付回调
     *
     * @param payNotify
     * @return
     * @throws BusinessException
     */
    public String payNotify(PayNotify payNotify) throws BusinessException;


}
