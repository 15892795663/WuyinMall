package org.wuyin.wuyinmall.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description:用户实体
 * @Author: wuyin
 * @Date: Created in 23:44 2020/5/27
 */
@Data
public class User {
    private int id;
    private String username;
    private String email;
    private int role;
    private String phone;
    private String question;
    private String answer;
    private Date createTime;//返回前端的是时间戳
    private Date updateTime;
}
