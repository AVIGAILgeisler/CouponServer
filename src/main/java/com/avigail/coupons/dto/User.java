package com.avigail.coupons.dto;

import com.avigail.coupons.enums.UserType;

public class User {
    private String userName;
    private  long id;
    private String password;
    private UserType type;
    private Long companyId;

    public User(String userName, String password, UserType type, Long companyId) {
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.companyId = companyId;
    }

    public User(String userName, long id, String password, UserType type, Long companyId) {
        this(userName,password,type,companyId);
        this.id = id;
    }
    public User() {
    }

    public User(String userName, String password, UserType type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType userType) {
        this.type = userType;
    }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", Password='" + password + '\'' +
                ", userType=" + type +
                ", companyId=" + companyId +
                '}';
    }
}
