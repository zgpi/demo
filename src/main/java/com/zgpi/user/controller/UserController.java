package com.zgpi.user.controller;

import com.zgpi.user.domain.User;
import com.zgpi.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(User user){
        user.setUserName("测试");
        user.setUserSex(1);
        user.setUserPwd("000001");
        userService.saveUser(user);
        return "success";
    }
}
