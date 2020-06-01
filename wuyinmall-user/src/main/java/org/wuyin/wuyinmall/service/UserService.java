package org.wuyin.wuyinmall.service;

import org.wuyin.wuyinmall.common.resp.ServerResponse;
import org.wuyin.wuyinmall.entity.User;

/**
 * @Description:
 * @Author: wuyin
 * @Date: Created in 12:34 2020/5/30
 */
public interface UserService {

    ServerResponse<User> login(String userName,String password);

}
