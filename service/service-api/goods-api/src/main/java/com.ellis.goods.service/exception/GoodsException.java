package com.ellis.goods.service.exception;

import com.ellis.common.service.exception.BaseErrorCode;
import com.ellis.common.service.exception.BusinessException;

/**
 * @author ellis.luo
 * @date 16/11/21 下午11:49
 * @description
 */
public class GoodsException extends BusinessException
{

    public GoodsException(BaseErrorCode baseErrorCode)
    {
        super(baseErrorCode);
    }
}
