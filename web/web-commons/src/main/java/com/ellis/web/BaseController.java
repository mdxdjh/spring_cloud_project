package com.ellis.web;

import com.ellis.common.service.entity.User;
import com.ellis.common.service.exception.BaseErrorCode;
import com.ellis.common.service.exception.BusinessException;
import com.ellis.web.common.Constants;
import com.ellis.web.common.ErrorCodeConst;
import org.slf4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ellis.luo
 * @date 16/11/22 上午12:22
 * @description
 */
public class BaseController
{
    private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    private final int SUCCESS_CODE = 200;

    // 检查valid的参数错误
    protected void checkParams(BindingResult result) throws BusinessException
    {
        if (result.hasErrors())
        {
            for (ObjectError error : result.getAllErrors())
            {
                logger.error("{} params error {}", getClass().getSimpleName(), error.getDefaultMessage());
            } ;
            throw new BusinessException(ErrorCodeConst.PARAMS_ERROR);
        }
    }

    protected long getLoginUid()
    {
        User user = (User) getHttpSession().getAttribute(Constants.SESSION_USER);
        return user.getUid();
    }

    /**
     * 获取HttpSession请求上下文
     *
     * @return
     */
    protected HttpSession getHttpSession()
    {
        return getRequest().getSession();
    }

    /**
     * 获取HttpServletRequest请求上下文
     *
     * @return
     */
    protected HttpServletRequest getRequest()
    {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取HttpServletResponse请求上下文
     *
     * @return
     */
    protected HttpServletResponse getResponse()
    {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected FrameResp successResp(Object body)
    {
        return new FrameResp().buildCode(SUCCESS_CODE).buildBody(body);
    }

    protected FrameResp successResp()
    {
        return new FrameResp().buildCode(SUCCESS_CODE).buildBody("操作成功");
    }

    protected FrameResp errorResp(BaseErrorCode errorCode)
    {
        return new FrameResp().buildCode(errorCode.getCode()).buildErrorMes(errorCode.getMessage());
    }

}
