package com.zgpi.controller;

import com.zgpi.dataobject.User;
import com.zgpi.exception.AppException;
import com.zgpi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RestController
@Slf4j
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public User login(@RequestParam("userId") String userId,
                      @RequestParam("userPwd") String userPwd){
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(userPwd)){
            throw new AppException("用户名或密码为空！");
        }
        User user = userService.findByUserId(userId);
        if(user == null){
            throw new AppException("用户名不存在！");
        }
        if(!userPwd.equals(user.getUserPwd())) {
            userPwd = DigestUtils.md5DigestAsHex(userPwd.getBytes());
            if (!userPwd.equals(user.getUserPwd())) {
                throw new AppException("密码错误！");
            }
        }else{
            userPwd = DigestUtils.md5DigestAsHex(userPwd.getBytes());
            userService.md5UserPwd(userId, userPwd);
        }
        return user;
    }

    @GetMapping("/saveUser")
    public String saveUser(){
        User user = new User();
        user.setUserId("test");
        user.setUserName("测试");
        user.setUserSex(1);
        user.setUserPwd("000001");
        userService.saveUser(user);
        return "success";
    }
}
