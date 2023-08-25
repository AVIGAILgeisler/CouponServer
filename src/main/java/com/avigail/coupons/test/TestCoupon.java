//package com.avigail.coupons.test;
//
//import com.avigail.coupons.exception.ApplicationException;
//import com.avigail.coupons.dto.Coupon;
//import com.avigail.coupons.logic.CouponLogic;
//
//import java.sql.Date;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class TestCoupon {
//    public static void main(String[] args) throws ApplicationException {
//        CouponLogic couponLogic = new CouponLogic();
//
//        LocalDateTime dateTime = LocalDateTime.now().plusMonths(2);
//        Date date1 = Date.valueOf(dateTime.toLocalDate());
//        Date date2 = Date.valueOf(dateTime.toLocalDate().plusMonths(24));
//
//
//        Coupon coupon1 = new Coupon("Gold", "Coupon for Restaurants", date1, date2, 10, 2, 100, 1);
//        Coupon coupon2 = new Coupon("Silver", "Coupon for Attractions", date1, date2, 3, 4, 90, 3);
//        Coupon coupon3 = new Coupon("Black", "Coupon for Movie", date1, date2, 1, 3, 60, 2);
//        Coupon coupon4 = new Coupon("White", "Coupon for Games", date1, date2, 5, 2, 50, 3);
//
//        try {
//            couponLogic.addCoupon(coupon1);
//            couponLogic.addCoupon(coupon2);
//            couponLogic.addCoupon(coupon3);
//            couponLogic.addCoupon(coupon4);
//
//            Coupon coupon = couponLogic.getCoupon(2);
//            coupon.setPrice(95);
//            couponLogic.updateCoupon(coupon);
////            couponLogic.deleteCoupon(3);
//
//            List<Coupon> coupons = couponLogic.getAllCoupons();
//            for (int i = 0; i < coupons.size(); i++) {
//                System.out.println(coupons.get(i));
//            }
//
//            System.out.println(couponLogic.getCouponsByCategoryId(2));
//            System.out.println(couponLogic.getCouponsByCompanyId(3));
//            System.out.println(couponLogic.getCouponsByMaxPrice(95));
//
//
//        } catch (ApplicationException e) {
//            e.printStackTrace();
//        }
//    }
//}
