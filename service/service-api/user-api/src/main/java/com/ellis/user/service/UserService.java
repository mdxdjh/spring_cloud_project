package com.ellis.user.service;

import com.ellis.common.service.page.PageData;
import com.ellis.user.service.exception.UserException;
import com.ellis.user.service.entity.UserInfo;

/**
 * @author ellis.luo
 * @date 16/11/19 下午10:40
 * @description
 */
public interface UserService
{
    /**
     * 注册
     * @param userInfo
     * @throws UserException
     */
    public void register(UserInfo userInfo) throws UserException;

    /**
     * 手机号登陆
     * @param mobile
     * @throws UserException
     */
    public UserInfo checkLogin(String mobile) throws UserException;

    /**
     * 通过uid查看用户信息
     * @param uid
     * @return
     * @throws UserException
     */
    public UserInfo queryUserByUid(long uid) throws UserException;

    public PageData queryPage() throws UserException;

}
