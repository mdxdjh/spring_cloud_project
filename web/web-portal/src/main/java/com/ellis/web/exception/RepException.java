package com.ellis.web.exception;

import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * Created by luoxiaowei on 2017/2/5.
 */
public class RepException extends IOException {

    private HttpStatus statusCode;

    private String body;

    public RepException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }

    public RepException(HttpStatus statusCode, String body, String msg) {
        super(msg);
        this.statusCode = statusCode;
        this.body = body;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
