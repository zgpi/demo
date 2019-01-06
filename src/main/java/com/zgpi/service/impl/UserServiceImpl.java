package com.zgpi.service.impl;

import com.zgpi.dataobject.User;
import com.zgpi.dataobject.mapper.UserMapper;
import com.zgpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userId, String userPwd) {
        return userMapper.login(userId, userPwd);
    }

    @Override
    public void md5UserPwd(String userId, String userPwd) {
        userMapper.md5UserPwd(userId, userPwd);
    }

    @Override
    public User findByUserId(String userId) {
        return userMapper.findByUserId(userId);
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }


}
