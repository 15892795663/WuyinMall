package org.wuyin.wuyinmall.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuyin.wuyinmall.common.exception.WuyinMallException;
import org.wuyin.wuyinmall.common.resp.ServerResponse;
import org.wuyin.wuyinmall.common.utils.MD5Util;
import org.wuyin.wuyinmall.dao.UserMapper;
import org.wuyin.wuyinmall.entity.User;
import org.wuyin.wuyinmall.service.UserService;

/**
 * @Description:
 * @Author: wuyin
 * @Date: Created in 12:44 2020/5/30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String userName, String password) {
        //一校验参数不能为空
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            throw new WuyinMallException("用户名或者密码不能为空");
        }
        //二、根据用户名去取用户信息
        int resultCount = userMapper.selectByUserName(userName);
        if (resultCount == 0) {
            throw new WuyinMallException("用户名不存在");
        }
        //三、校验用户名密码
        String ma5Password = MD5Util.MD5EncodeUtf8(password);
        User resultUser = userMapper.selectByUsernameAndPassword(userName,password);
        if(resultUser == null){
            throw new WuyinMallException("用户名或者密码不正确");
        }
        //四、返回成功
        return ServerResponse.createBySuccess("用户登录成功",resultUser);
    }
}
