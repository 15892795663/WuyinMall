package org.wuyin.wuyinmall.common.resp;

import lombok.Getter;

/**
 * @Description:基本的返回状态描述
 * @Author: wuyin
 * @Date: Created in 23:26 2020/5/28
 */
@Getter
public enum ResponseEnum {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ILLEGAL_ARGUMENTS(2,"ILLEGAL_ARGUMENTS"),
    NEED_LOGIN(10,"NEED_LOGIN");

    private int code;
    private String desc;

    ResponseEnum(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
