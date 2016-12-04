package com.ellis.order.service.common;

import com.ellis.common.service.exception.BaseErrorCode;

/**
 * @author ellis.luo
 * @date 16/11/22 上午12:17
 * @description 订单错误 2000 ~ 3000
 */
public class ErrorCodeConst
{
    public static final BaseErrorCode PARAMS_ERROR = new BaseErrorCode(2001, "参数错误");
    public static final BaseErrorCode GOODS_NOT_EXISTS = new BaseErrorCode(2002, "商品不存在");

}
