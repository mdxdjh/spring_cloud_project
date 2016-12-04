package com.ellis.user.service.common;

import com.ellis.common.service.exception.BaseErrorCode;

/**
 * @author ellis.luo
 * @date 16/11/22 上午12:17
 * @description 用户错误 1000 ~ 2000
 */
public class ErrorCodeConst
{
    public static final BaseErrorCode PARAMS_ERROR = new BaseErrorCode(1001, "参数错误");
    public static final BaseErrorCode USER_NOT_EXISTS = new BaseErrorCode(1002, "用户不存在");

}
