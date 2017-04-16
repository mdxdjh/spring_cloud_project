//package com.ellis.web.interceptor;
//
//import com.alibaba.fastjson.JSON;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by luoxiaowei on 2017/2/8.
// */
//@ControllerAdvice
//class GlobalDefaultExceptionHandler {
//    public static final String DEFAULT_ERROR_VIEW = "error";
//
//    private Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
//
//    @ExceptionHandler(value = Exception.class)
//    public void
//    defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        logger.info("11=========={}", req);
//        logger.info("22=========={}",  e.getMessage());
//        // If the exception is annotated with @ResponseStatus rethrow it and let
//        // the framework handle it - like the OrderNotFoundException example
//        // at the start of this post.
//        // AnnotationUtils is a Spring Framework utility class.
//        if (AnnotationUtils.findAnnotation
//                (e.getClass(), ResponseStatus.class) != null)
//            throw e;
//
//
//
//
//
//    }
//}