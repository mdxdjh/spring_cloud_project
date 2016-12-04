package com.ellis.order.service.exception;

import com.ellis.common.service.exception.BaseErrorCode;
import com.ellis.common.service.exception.BusinessException;

/**
 * @author ellis.luo
 * @date 16/11/21 下午11:49
 * @description
 */
public class OrderException extends BusinessException
{

    public OrderException(BaseErrorCode baseErrorCode)
    {
        super(baseErrorCode);
    }
}
