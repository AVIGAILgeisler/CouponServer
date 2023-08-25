package com.avigail.coupons.entities;

import com.avigail.coupons.dto.User;
import com.avigail.coupons.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private CompanyEntity company;

    @Column(name = "user_name", unique = false, nullable = true)
    private String userName;

    @Column(name = "password", unique = false, nullable = true)
    private String password;

    @Column(name = "type", unique = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<PurchaseEntity> purchasesList;

    public UserEntity(User user) {
        this.userName = user.getUserName();
        this.id = user.getId();
        this.password = user.getPassword();
        this.type = user.getType();
        if (this.type == UserType.COMPANY) {
            this.company = new CompanyEntity();
            this.company.setId(user.getCompanyId());
        }
    }
    public UserEntity() {
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public void setId(long id) {
        this.id = id;
    }
}
