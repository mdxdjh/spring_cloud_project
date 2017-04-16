//package com.ellis.web.interceptor;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author ellis.luo
// * @date 16/11/22 下午11:59
// * @description 异常转换成中文
// */
//@Component
//public class ExceptionEncodingResolver implements HandlerExceptionResolver
//{
//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//            Exception ex)
//    {
//        response.setCharacterEncoding("utf-8");
//        return null;
//    }
//}
