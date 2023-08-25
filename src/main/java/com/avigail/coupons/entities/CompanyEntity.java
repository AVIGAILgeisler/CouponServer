package com.avigail.coupons.entities;

import com.avigail.coupons.dto.Company;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany (mappedBy = "company", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<UserEntity> userEntityList;

    @OneToMany (mappedBy ="company", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<CouponEntity> couponEntities;
    @Column(name = "name", unique = true, nullable = true)
    private String name;

    @Column(name = "vat_number", unique = true, nullable = true)
    private int vatNumber;

    @Column(name = "address", unique = false, nullable = false)
    private String address;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public CompanyEntity(Company company) {
        this.name = company.getName();
        this.vatNumber = company.getVatNumber();
        this.address = company.getAddress();
        this.phoneNumber = company.getPhoneNumber();
        this.email = company.getEmail();
    }

    public CompanyEntity() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public List<CouponEntity> getCouponEntities() {
        return couponEntities;
    }

    public void setCouponEntities(List<CouponEntity> couponEntities) {
        this.couponEntities = couponEntities;
    }
}
