package com.ellis.user;

import com.ellis.user.service.UserService;
import com.ellis.user.service.common.ErrorCodeConst;
import com.ellis.user.dal.db.UserInfoPo;
import com.ellis.user.dal.db.UserInfoPoExample;
import com.ellis.user.dal.db.UserInfoPoMapper;
import com.ellis.user.dal.db.convert.UserConvertUtil;
import com.ellis.user.service.entity.UserInfo;
import com.ellis.user.service.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ellis.luo
 * @date 16/11/20 上午8:18
 * @description
 */
public class UserServiceImpl implements UserService
{
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserInfoPoMapper userInfoPoMapper;

    @Override
    public void register(UserInfo userInfo) throws UserException
    {
        UserInfoPo po = UserConvertUtil.info2Po(userInfo);
        userInfoPoMapper.insert(po);
    }

    @Override
    public UserInfo checkLogin(String mobile) throws UserException
    {
        UserInfoPoExample example = new UserInfoPoExample();
        example.createCriteria().andPhoneEqualTo(mobile);
        List<UserInfoPo> pos = userInfoPoMapper.selectByExample(example);
        if (pos.size() == 0 || pos == null)
        {
            logger.error("checkLogin user not exists . mobile:{}", mobile);
            throw new UserException(ErrorCodeConst.USER_NOT_EXISTS);
        }

        return UserConvertUtil.po2Info(pos.get(0));
    }

    @Override
    public UserInfo queryUserByUid(long uid) throws UserException
    {
        UserInfoPo po = userInfoPoMapper.selectByPrimaryKey(uid);

        return UserConvertUtil.po2Info(po);
    }

}