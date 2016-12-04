package com.ellis.web;

/**
 * @author ellis.luo
 * @date 16/11/26 下午4:15
 * @description
 */
public class FrameResp
{
    private int code;
    private String errorMes;
    private Object body;

    public FrameResp buildCode(int code) {
        setCode(code);
        return this;
    }

    public FrameResp buildBody(Object body) {
        setBody(body);
        return this;
    }

    public FrameResp buildErrorMes(String errorMes) {
        setErrorMes(errorMes);
        return this;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getErrorMes()
    {
        return errorMes;
    }

    public void setErrorMes(String errorMes)
    {
        this.errorMes = errorMes;
    }

    public Object getBody()
    {
        return body;
    }

    public void setBody(Object body)
    {
        this.body = body;
    }
}
