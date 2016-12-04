package com.ellis.goods.service.common;

import com.ellis.common.service.exception.BaseErrorCode;

/**
 * @author ellis.luo
 * @date 16/11/22 上午12:17
 * @description 商品错误 3000 ~ 4000
 */
public class ErrorCodeConst
{
    public static final BaseErrorCode PARAMS_ERROR = new BaseErrorCode(3001, "参数错误");
    public static final BaseErrorCode GOODS_NOT_EXISTS = new BaseErrorCode(3002, "商品不存在");

}
