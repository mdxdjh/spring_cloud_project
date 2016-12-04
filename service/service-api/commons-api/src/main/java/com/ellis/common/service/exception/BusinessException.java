package com.ellis.common.service.exception;

/**
 * @author ellis.luo
 * @date 16/11/21 下午11:50
 * @description
 */
public class BusinessException extends RuntimeException
{
    private static final long serialVersionUID = -7887057238055620806L;
    private final BaseErrorCode baseErrorCode;

    public BusinessException(BaseErrorCode baseErrorCode)
    {
        this.baseErrorCode = baseErrorCode;
    }

    public BaseErrorCode getCode()
    {
        return baseErrorCode;
    }

    @Override
    public String getMessage()
    {
        return String.format("code : %s ; msg : %s", baseErrorCode.getCode(), baseErrorCode.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace()
    {
        return this;
    }
}
