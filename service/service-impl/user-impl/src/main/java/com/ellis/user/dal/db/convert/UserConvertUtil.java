package com.ellis.user.dal.db.convert;

import com.ellis.user.dal.db.UserInfoPo;
import com.ellis.user.service.entity.UserInfo;

/**
 * @author ellis.luo
 * @date 16/11/21 下午6:55
 * @description
 */
public class UserConvertUtil
{
    public static UserInfoPo info2Po(UserInfo userInfo)
    {
        UserInfoPo po = new UserInfoPo();
        po.setUid(userInfo.getUid());
        po.setPhone(userInfo.getPhone());
        po.setPassword(userInfo.getPassword());
        po.setName(userInfo.getName());
        po.setUsername(userInfo.getUsername());
        return po;
    }

    public static UserInfo po2Info(UserInfoPo po)
    {
        UserInfo info = new UserInfo();
        info.setUid(po.getUid());
        info.setPhone(po.getPhone());
        info.setPassword(po.getPassword());
        info.setName(po.getName());
        info.setUsername(po.getUsername());
        return info;
    }
}
