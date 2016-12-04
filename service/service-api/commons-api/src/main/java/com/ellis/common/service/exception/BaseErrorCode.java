package com.ellis.common.service.exception;

import java.io.Serializable;

/**
 * @author ellis.luo
 * @date 16/11/21 下午11:51
 * @description
 */
public class BaseErrorCode implements Serializable
{
    private static final long serialVersionUID = 1982607259137204522L;

    private final int code;
    private String message;

    public BaseErrorCode(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public int getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "BaseErrorCode [code=" + code + ", message=" + message + "]";
    }

}
