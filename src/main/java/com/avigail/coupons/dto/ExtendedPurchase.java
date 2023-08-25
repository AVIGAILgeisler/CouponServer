package com.avigail.coupons.dto;

import java.util.Date;

public class ExtendedPurchase extends Purchase{
    private String couponName;
    private String couponDescription;
    private float couponPrice;
    private Date startDate;
    private Date endDate;
    private Long companyId;
    private String companyName;
    private String userName;
    private long categoryId;
    private String categoryName;

    public ExtendedPurchase() {
    }

    public ExtendedPurchase(long id, long couponId, long userId, int amount, Date date, String couponName, String couponDescription, float couponPrice, Date startDate, Date endDate, Long companyId, String companyName, String userName, long categoryId, String categoryName) {
        super(id, couponId, userId, amount, date);
        this.couponName = couponName;
        this.couponDescription = couponDescription;
        this.couponPrice = couponPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyId = companyId;
        this.companyName = companyName;
        this.userName = userName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCouponName() {
        return couponName;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public float getCouponPrice() {
        return couponPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getUserName() {
        return userName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "ExtendedPurchase{" +super.toString()+
                "couponName='" + couponName + '\'' +
                ", couponDescription='" + couponDescription + '\'' +
                ", couponPrice=" + couponPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", userName='" + userName + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName +
                '}';
    }
}
