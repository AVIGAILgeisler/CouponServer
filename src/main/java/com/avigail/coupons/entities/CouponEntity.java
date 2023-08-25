package com.avigail.coupons.entities;

import com.avigail.coupons.dto.Coupon;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupons")
public class CouponEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private CompanyEntity company;

    @ManyToOne
    private CategoryEntity category;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<PurchaseEntity> purchases;

    @Column(name = "name",unique = true,nullable = true)
    private String name;

    @Column(name = "description",unique = false,nullable = true)
    private String description;

    @Column(name = "start_date",unique = false,nullable = false)
    private Date startDate;

    @Column(name = "end_date",unique = false,nullable = false)
    private Date endDate;

    @Column(name = "amount",unique = false,nullable = true)
    private int amount;

    @Column(name = "price",unique = false,nullable = true)
    private float price;

    public CouponEntity(Coupon coupon) {
        this.id = coupon.getId();
        this.company = new CompanyEntity();
        this.company.setId(coupon.getCompanyId());
        this.category= new CategoryEntity();
        this.category.setId(coupon.getCategoryId());
        this.name = coupon.getName();
        this.description = coupon.getDescription();
        this.startDate = coupon.getStartDate();
        this.endDate = coupon.getEndDate();
        this.amount = coupon.getAmount();
        this.price = coupon.getPrice();
    }

    public CouponEntity() {
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
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

    public int getAmount() {
        return amount;
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

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

}
