package com.ellis.common.service.entity;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author ellis.luo
 * @date 16/11/20 下午2:13
 * @description
 */
public class BaseModel implements Serializable
{
    private static final long serialVersionUID = 7865323146996853681L;

    // 性能很差,最好自己覆盖,否则打日志严重影响性能
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
