package com.avigail.coupons.dal;

import com.avigail.coupons.dto.Coupon;
import com.avigail.coupons.dto.ExtendedCoupon;
import com.avigail.coupons.entities.CouponEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ICouponsDal extends CrudRepository<CouponEntity, Long> {

    @Query("SELECT new com.avigail.coupons.dto.ExtendedCoupon (c.id, c.name, c.description, c.startDate, c.endDate, c.amount, c.category.id, c.price, c.company.id, c.category.name, c.company.name) FROM CouponEntity c WHERE c.id= :id")
    ExtendedCoupon getCoupon(@Param("id")long id);
    @Query("SELECT new com.avigail.coupons.dto.ExtendedCoupon (c.id, c.name, c.description, c.startDate, c.endDate, c.amount, c.category.id, c.price, c.company.id, c.category.name, c.company.name) FROM CouponEntity c")
    List<ExtendedCoupon> getAllCoupons();

    @Query("SELECT new com.avigail.coupons.dto.ExtendedCoupon (c.id, c.name, c.description, c.startDate, c.endDate, c.amount, c.category.id, c.price, c.company.id, c.category.name, c.company.name) FROM CouponEntity c WHERE c.category.id= :categoryId")
    List<ExtendedCoupon> getCouponsByCategoryId(@Param("categoryId")long id);

    @Query("SELECT new com.avigail.coupons.dto.ExtendedCoupon (c.id, c.name, c.description, c.startDate, c.endDate, c.amount, c.category.id, c.price, c.company.id, c.category.name, c.company.name) FROM CouponEntity c WHERE c.company.id= :companyId")
    List<ExtendedCoupon>  getCouponsByCompanyId(@Param("companyId")long id);

    @Query("SELECT new com.avigail.coupons.dto.ExtendedCoupon (c.id, c.name, c.description, c.startDate, c.endDate, c.amount, c.category.id, c.price, c.company.id, c.category.name, c.company.name) FROM CouponEntity c WHERE c.startDate> :startDate AND c.endDate< :endDate")
    List<ExtendedCoupon>  getByDateRange(@Param("startDate")Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT new com.avigail.coupons.dto.ExtendedCoupon (c.id, c.name, c.description, c.startDate, c.endDate, c.amount, c.category.id, c.price, c.company.id, c.category.name, c.company.name) FROM CouponEntity c WHERE c.price< :maxPrice")
    List<ExtendedCoupon>  getCouponsByMaxPrice(@Param("maxPrice")float price);

}
