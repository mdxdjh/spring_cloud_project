package com.ellis.web.controller;

import com.ellis.common.service.page.PageData;
import com.ellis.common.service.entity.User;
import com.ellis.user.service.UserService;
import com.ellis.user.service.entity.UserInfo;
import com.ellis.user.service.exception.UserException;
import com.ellis.web.BaseController;
import com.ellis.web.common.Constants;
import com.ellis.web.FrameResp;
import com.ellis.web.common.RequiredLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author ellis.luo
 * @date 16/11/18 上午12:35
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController
{
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public FrameResp register(@Validated UserInfo userInfo, BindingResult result) throws UserException
    {
        checkParams(result);

        logger.info("UserController register begin, userInfo:{}", userInfo);
        userService.register(userInfo);
        return successResp();
    }

    @RequestMapping(value = "/phoneLogin", method = RequestMethod.POST)
    public FrameResp phoneLogin(@RequestParam String phone) throws UserException
    {
        logger.info("UserController checkLogin begin, phone:{}", phone);
        UserInfo user = userService.checkLogin(phone);

        saveUserSession(user);

        return successResp();
    }

    private void saveUserSession(UserInfo info)
    {
        HttpSession session = getHttpSession();

        User user = new User(info.getUid());

        // 保存用户id|终端类型
        session.setAttribute(Constants.SESSION_USER, user);

    }

    @RequiredLogin
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public FrameResp queryUserInfo(@RequestParam long uid) throws UserException
    {
        logger.info("UserController queryUserInfo begin, uid:{}", "1");
        UserInfo user = userService.queryUserByUid(uid);
        return successResp(user);
    }

    @RequiredLogin
    @RequestMapping(value = "/queryPage", method = RequestMethod.GET)
    public FrameResp queryPage() throws UserException
    {
        logger.info("UserController queryPage begin, uid:{}", "1");
        PageData result = userService.queryPage();
        return successResp(result);
    }

}
