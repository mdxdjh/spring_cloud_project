package com.ellis.user;

import com.alibaba.fastjson.JSON;
import com.ellis.user.dal.db.UserInfoPo;
import com.ellis.user.dal.db.UserInfoPoExample;
import com.ellis.user.dal.db.UserInfoPoMapper;
import com.ellis.user.dal.db.convert.UserConvertUtil;
import com.ellis.user.service.UserService;
import com.ellis.user.service.common.ErrorCodeConst;
import com.ellis.user.service.entity.UserInfo;
import com.ellis.user.service.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ellis.luo
 * @date 16/11/20 上午8:18
 * @description
 */
@RestController
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserInfoPoMapper userInfoPoMapper;

    @Override
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserInfo userInfo) throws UserException {
        logger.info("register input:{} ", JSON.toJSONString(userInfo));
        UserInfoPo po = UserConvertUtil.info2Po(userInfo);
        userInfoPoMapper.insert(po);
    }

    @Override
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public UserInfo checkLogin(@RequestBody String mobile) throws UserException {
        logger.info("checkLogin input:{} ", mobile);
        UserInfoPoExample example = new UserInfoPoExample();
        example.createCriteria().andPhoneEqualTo(mobile);
        List<UserInfoPo> pos = userInfoPoMapper.selectByExample(example);
        if (pos.size() == 0 || pos == null) {
            logger.error("checkLogin user not exists . mobile:{}", mobile);

            throw new UserException(ErrorCodeConst.USER_NOT_EXISTS);
        }

        return UserConvertUtil.po2Info(pos.get(0));
    }

    @Override
    @RequestMapping(value = "/get/{uid}", method = RequestMethod.GET)
    public UserInfo queryUserByUid(@PathVariable long uid) throws UserException {
        logger.info("queryUserByUid uid : {}", uid);
        UserInfoPo po = userInfoPoMapper.selectByPrimaryKey(uid);

        return UserConvertUtil.po2Info(po);
    }

//    @Override
//    public PageData queryPage() throws UserException {
//        UserInfoPoExample example = new UserInfoPoExample();
//        example.createCriteria().andUsernameEqualTo("22222");
//        List<UserInfoPo> pos = userInfoPoMapper.selectByExample(example);
//        PageData result = PageData.getByList(UserConvertUtil.batchPo2Info(pos), 2, 2);
//        return result;
//    }

}
