package com.zgpi.service;

import com.zgpi.dataobject.User;

public interface UserService {

    public User login(String userId, String userPwd);

    public void md5UserPwd(String userId, String userPwd);

    public User findByUserId(String userId);

    public void saveUser(User user);
}
