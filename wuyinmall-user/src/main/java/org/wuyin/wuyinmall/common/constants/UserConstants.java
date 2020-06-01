package org.wuyin.wuyinmall.common.constants;

/**
 * @Description:
 * @Author: wuyin
 * @Date: Created in 22:42 2020/5/28
 */
public interface UserConstants {
    /**自定义状态码 start**/
    public static final int RESP_STATUS_OK = 200;

    public static final int RESP_STATUS_NOAUTH = 401;

    public static final int RESP_STATUS_INTERNAL_ERROR = 500;

    public static final int RESP_STATUS_BADREQUEST = 400;

    /**自定义状态码 end**/

    int REDIS_SESSION_EXTIME = 60 * 60 * 10;//30分钟

}
