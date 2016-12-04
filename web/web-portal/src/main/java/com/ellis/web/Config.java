package com.ellis.web;

import com.ellis.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author ellis.luo
 * @date 16/11/25 下午2:13
 * @description
 */
@Configuration
public class Config extends WebMvcConfigurationSupport
{
    @Override
    protected void addInterceptors(InterceptorRegistry registry)
    {
        // 用户登录验证
        registry.addInterceptor(new LoginInterceptor());
    }
}
