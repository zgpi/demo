package com.zgpi.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class User {

    @Id
    private String userId;
    private String userName;
    private Integer userSex;
    private String userPwd;
    private Timestamp lastLogin;
}
