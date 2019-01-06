package com.zgpi.dataobject.mapper;

import com.zgpi.dataobject.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    User login(@Param("user_id") String userId, @Param("user_pwd") String userPwd);

    void md5UserPwd(@Param("user_id") String userId, @Param("user_pwd") String userPwd);

    User findByUserId(String userId);

    void saveUser(User user);

}
