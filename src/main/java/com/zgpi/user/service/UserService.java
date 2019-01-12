package com.zgpi.user.service;

import com.zgpi.user.domain.User;

public interface UserService {

    public String login(String userId, String userPwd);

    public void md5UserPwd(String userId, String userPwd);

    public User findByUserId(String userId);

    public void saveUser(User user);
}
