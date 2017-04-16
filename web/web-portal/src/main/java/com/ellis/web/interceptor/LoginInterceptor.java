package com.ellis.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.ellis.common.service.entity.User;
import com.ellis.web.exception.AuthFailException;
import com.ellis.web.common.Constants;
import com.ellis.web.common.RequiredLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author ellis.luo
 * @date 16/11/25 下午1:42
 * @description 登陆鉴权
 */
public class LoginInterceptor extends HandlerInterceptorAdapter
{

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        RequiredLogin requiredLogin = AnnotationUtils.findAnnotation(method, RequiredLogin.class);
        if (requiredLogin == null)
        {
            return true;
        }

        HttpSession session = request.getSession(false);
        logger.info("====={}", JSON.toJSONString(session));
        if (session == null)
        {
            throw new AuthFailException();
        }

        User user = (User) session.getAttribute(Constants.SESSION_USER);
        if (user == null)
        {
            throw new AuthFailException();
        }

        return true;
    }

}
