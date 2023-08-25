package com.avigail.coupons.dto;

import java.util.Date;

public class Coupon {
    private long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private long categoryId;
    private float price;
    private long companyId;

    public Coupon(long id, String name, String description, Date startDate, Date endDate, int amount, long categoryId, float price, long companyId) {
        this(name,description,startDate, endDate,amount,categoryId,price,companyId);
        this.id = id;

    }

    public Coupon(String name, String description, Date startDate, Date endDate, int amount, long categoryId, float price, long companyId) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.categoryId = categoryId;
        this.price = price;
        this.companyId=companyId;
    }

    public Coupon() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public int getAmount() {
        return amount;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getCompanyId() {
        return companyId;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", categoryId='" + categoryId + '\'' +
                ", price=" + price +
                ", companyId=" + companyId +
                '}';
    }
}
