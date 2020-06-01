package org.wuyin.wuyinmall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.wuyin.wuyinmall.entity.User;

/**
 * @Description:
 * @Author: wuyin
 * @Date: Created in 11:02 2020/5/31
 */
public interface UserMapper {
    int selectByUserName(String userName);

    User selectByUsernameAndPassword(String userName, String password);
}
