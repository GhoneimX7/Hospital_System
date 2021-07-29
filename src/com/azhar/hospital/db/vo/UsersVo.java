package com.azhar.hospital.db.vo;

import com.azhar.hospital.db.type.UsersType;

/**
 *
 * @author fastox
 */
public class UsersVo {
    private int id;
    private String userName;
    private String password;
    private UsersType usersType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersType getUsersType() {
        return usersType;
    }

    public void setUsersType(UsersType usersType) {
        this.usersType = usersType;
    }
    
}
