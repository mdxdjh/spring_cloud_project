//package com.ellis.web.exception;
//
//import com.alibaba.fastjson.JSON;
//import com.ellis.common.service.exception.BaseErrorCode;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.web.client.DefaultResponseErrorHandler;
//import org.springframework.web.client.ResponseErrorHandler;
//import org.springframework.web.client.RestClientException;
//
//import java.io.IOException;
//
///**
// * Created by luoxiaowei on 2017/2/5.
// */
//public class RestResponseErrorHandler implements  {
//    private static final Logger logger = LoggerFactory.getLogger(RestResponseErrorHandler.class);
//
//    private ResponseErrorHandler myErrorHandler = new DefaultResponseErrorHandler();
//
//    @Override
//    public void handleError(ClientHttpResponse response) throws IOException {
//        String body = JSON.toJSONString(response.getBody());
//        RepException exception = new RepException(response.getStatusCode(), body, body);
//        logger.info("=========={}",JSON.toJSONString(response));
//        throw exception;
//    }
//
//    @Override
//    public boolean hasError(ClientHttpResponse response) throws IOException {
//        return myErrorHandler.hasError(response);
////        HttpStatus.Series series = response.getStatusCode().series();
////        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
////                || HttpStatus.Series.SERVER_ERROR.equals(series));
//
//    }
//}
