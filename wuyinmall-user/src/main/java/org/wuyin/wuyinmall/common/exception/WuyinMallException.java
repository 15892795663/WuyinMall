package org.wuyin.wuyinmall.common.exception;

import org.wuyin.wuyinmall.common.resp.ResponseEnum;

/**
 * @Description:
 * @Author: wuyin
 * @Date: Created in 23:26 2020/5/28
 */
public class WuyinMallException extends RuntimeException{
    private int exceptionStatus = ResponseEnum.ERROR.getCode();

    public WuyinMallException(String msg){
        super(msg);
    }

    public WuyinMallException(int code,String msg){
        super(msg);
        exceptionStatus = code;
    }
}
