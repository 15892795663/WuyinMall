package org.wuyin.wuyinmall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wuyin.wuyinmall.cache.CommonCacheUtil;
import org.wuyin.wuyinmall.common.constants.UserConstants;
import org.wuyin.wuyinmall.common.resp.ServerResponse;
import org.wuyin.wuyinmall.common.utils.CookieUtil;
import org.wuyin.wuyinmall.common.utils.JsonUtil;
import org.wuyin.wuyinmall.entity.User;
import org.wuyin.wuyinmall.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: wuyin
 * @Date: Created in 11:14 2020/5/30
 */
@RestController
@RequestMapping("user")
@Slf4j
@Api(value="UserContrller",tags = {"用户服务接口"})
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommonCacheUtil commonCacheUtil;
    /**
     * 用户登陆：验证参数、登陆、写到cookie中并且写到redis中
     * 用户登陆以后，点击其他需要登陆才能看的页面时，先判断是否前端是否有这个key，没有则提示需要登陆
     */
    @ApiOperation(value = "用户登录",notes = "输入用户名密码不能为空")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String")
    })
    @RequestMapping(value = "login.do")
    public ServerResponse<User> login(HttpSession httpSession, HttpServletResponse httpServletResponse,String userName,String password){
        log.info("【用户{}开始登录】",userName);
        ServerResponse<User> userServerResponse = userService.login(userName,password);
        if(userServerResponse.isSuccess()){
            //登陆成功后需要在redis中存储并且将代表用的的sessionId写道前端浏览器的cookie中
            log.info("【用户{}cookie开始写入】",userName);
            CookieUtil.writeLoginToken(httpServletResponse,httpSession.getId());
            //写道redis中，将用户信息序列化，设置过期时间三十分钟
            log.info("【用户{}redis开始写入】",userName);
            commonCacheUtil.cacheNxExpire(httpSession.getId(), JsonUtil.obj2String(userServerResponse.getData()), UserConstants.REDIS_SESSION_EXTIME);
        }
        return userServerResponse;
    }
}
