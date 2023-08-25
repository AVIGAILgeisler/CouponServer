package com.avigail.coupons.dto;

public class Company {
    private long id;
    private String name;
    private int vatNumber;
    private String address;
    private String phoneNumber;
    private String email;

    public Company(long id, String name, int vatNumber, String address, String phoneNumber, String email) {
        this(name, vatNumber, address, phoneNumber, email);
        this.id = id;
    }
    public Company(String name, int vatNumber, String address, String phoneNumber, String email) {
        this.name = name;
        this.vatNumber = vatNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Company() {
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

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vatNumber=" + vatNumber +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email=" + email +
                '}';
    }
}