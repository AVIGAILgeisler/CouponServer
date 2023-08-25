package com.avigail.coupons.dto;

import java.util.Date;

public class Purchase {
    private long id;
    private long couponId;
    private long userId;
    private int amount;
    private Date date;


    public Purchase(long id, long couponId, long userId, int amount, Date date) {
        this (couponId,userId,amount,date);
        this.id = id;
    }
    public Purchase(long couponId, long userId, int amount, Date date) {
        this.couponId = couponId;
        this.userId = userId;
        this.amount = amount;
        this.date = date;
    }

    public Purchase() {
    }

    public long getId() {
        return id;
    }

    public long getCouponId() {
        return couponId;
    }

    public long getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", couponId=" + couponId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
