package org.wuyin.wuyinmall.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuyin.wuyinmall.common.constants.UserConstants;
import org.wuyin.wuyinmall.common.resp.ServerResponse;

/**
 * @Description:
 * @Author: wuyin
 * @Date: Created in 22:53 2020/5/28
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandleAdvice {

    @ExceptionHandler(Exception.class)
    public ServerResponse handleException(Exception e){
        log.error(e.getMessage(),e);
        return ServerResponse.createByErrorCodeMessage(UserConstants.RESP_STATUS_INTERNAL_ERROR,e.getMessage());
    }

    @ExceptionHandler(WuyinMallException.class)
    public ServerResponse handleException(WuyinMallException e){
        log.error(e.getMessage(),e);
        return ServerResponse.createByErrorCodeMessage(UserConstants.RESP_STATUS_INTERNAL_ERROR,e.getMessage());
    }

}
