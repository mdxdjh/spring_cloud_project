package com.ellis.common.service.entity;

import java.io.Serializable;

/**
 * @author ellis.luo
 * @date 16/11/27 下午11:00
 * @description
 */
public class User implements Serializable
{
    private long uid;
    private String platform; // 平台

    public User(long uid)
    {
        this.uid = uid;
    }

    public User(long uid, String platform)
    {
        this.uid = uid;
        this.platform = platform;
    }

    public long getUid()
    {
        return uid;
    }

    public void setUid(long uid)
    {
        this.uid = uid;
    }

    public String getPlatform()
    {
        return platform;
    }

    public void setPlatform(String platform)
    {
        this.platform = platform;
    }
}
