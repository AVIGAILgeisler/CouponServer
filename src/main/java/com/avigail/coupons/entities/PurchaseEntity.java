package com.avigail.coupons.entities;

import com.avigail.coupons.dto.ExtendedPurchase;
import com.avigail.coupons.dto.Purchase;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchases")
public class PurchaseEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private CouponEntity coupon;

    @ManyToOne
    private UserEntity user;

    @Column(name = "amount",unique = false,nullable = true)
    private int amount;

    @Column(name = "date",unique = false,nullable = false)
    private java.util.Date date;


    public PurchaseEntity(Purchase purchase) {
        this.id = purchase.getId();
        this.coupon = new CouponEntity();
        this.coupon.setId(purchase.getCouponId());
        this.user = new UserEntity();
        this.user.setId(purchase.getUserId());
        this.amount = purchase.getAmount();
        this.date = purchase.getDate();
    }

    public PurchaseEntity() {
    }

    public long getId() {
        return id;
    }

    public float getAmount() {
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
}

