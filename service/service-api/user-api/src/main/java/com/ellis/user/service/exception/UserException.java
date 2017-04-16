package com.ellis.user.service.exception;

import com.ellis.common.service.exception.BaseErrorCode;
import com.ellis.common.service.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ellis.luo
 * @date 16/11/21 下午11:49
 * @description
 */
public class UserException extends BusinessException {
    public UserException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
