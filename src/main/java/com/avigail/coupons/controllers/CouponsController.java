package com.avigail.coupons.controllers;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dto.Coupon;
import com.avigail.coupons.dto.ExtendedCoupon;
import com.avigail.coupons.logic.CouponLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponsController {

    private CouponLogic couponLogic;

    @Autowired
    public CouponsController(CouponLogic couponLogic) {
        this.couponLogic = couponLogic;
    }

    @PostMapping
    public void addCoupon(@RequestBody Coupon coupon) throws ApplicationException {
         this.couponLogic.addCoupon(coupon);
    }

    @PutMapping
    public void updateCoupon(@RequestBody Coupon coupon) throws ApplicationException {
        this.couponLogic.updateCoupon(coupon);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable ("id") long id) throws ApplicationException {
        this.couponLogic.deleteCoupon(id);
    }
    //http://localhost:8080/coupons/byCategoryId?categoryId=
    @GetMapping("/byCategoryId")
    public List<ExtendedCoupon> getCouponsByCategoryId(@RequestParam ("categoryId")long categoryId) throws ApplicationException {
        return this.couponLogic.getCouponsByCategoryId(categoryId);
    }
    //http://localhost:8080/coupons/byCompanyId?companyId=
    @GetMapping("/byCompanyId")
    public List<ExtendedCoupon> getCouponsByCompanyId(@RequestParam ("companyId")long companyId) throws ApplicationException {
        return this.couponLogic.getCouponsByCompanyId(companyId);
    }

    //http://localhost:8080/coupons/byMaxPrice?maxPrice=
    @GetMapping("/byMaxPrice")
    public List<ExtendedCoupon> getCouponsByMaxPrice(@RequestParam ("maxPrice")float maxPrice) throws ApplicationException {
        return this.couponLogic.getCouponsByMaxPrice(maxPrice);
    }
    @GetMapping("/byDateRange")
    public List<ExtendedCoupon> getByDateRange(@RequestParam ("startDate")java.util.Date startDate, @RequestParam ("endDate")java.util.Date endDate) throws ApplicationException {
        return this.couponLogic.getByDateRange(startDate,endDate);
    }
    @GetMapping
    public List<ExtendedCoupon> getAllCoupons() throws ApplicationException {
        return this.couponLogic.getAllCoupons();
    }

    @GetMapping("/{id}")
    public ExtendedCoupon getCoupon(@PathVariable ("id") long id) throws ApplicationException {
        return this.couponLogic.getCoupon(id);
    }
}
