package com.avigail.coupons.dto;

import com.avigail.coupons.enums.UserType;

public class UserData {

    private String userName;
    private  long id;
    private UserType type;
    private Long companyId;

    public UserData() {
    }

    public UserData(String userName, long id, UserType type, Long companyId) {
        this.userName = userName;
        this.id = id;
        this.type = type;
        this.companyId = companyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
