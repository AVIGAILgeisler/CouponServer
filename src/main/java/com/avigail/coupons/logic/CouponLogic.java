package com.avigail.coupons.logic;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dal.ICouponsDal;
import com.avigail.coupons.dto.Coupon;
import com.avigail.coupons.dto.ExtendedCoupon;
import com.avigail.coupons.entities.CouponEntity;
import com.avigail.coupons.enums.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponLogic {
    private ICouponsDal couponsDal;
    private  CompanyLogic companyLogic;
    private  CategoryLogic categoryLogic;

    @Autowired
    public CouponLogic(ICouponsDal couponsDal, CompanyLogic companyLogic,CategoryLogic categoryLogic) {
        this.couponsDal = couponsDal;
        this.companyLogic = companyLogic;
        this.categoryLogic= categoryLogic;
    }

    public CouponLogic() {
    }

    public void addCoupon(Coupon coupon) throws ApplicationException {
        validateCoupon(coupon);
        CouponEntity couponEntity = new CouponEntity(coupon);
        this.couponsDal.save(couponEntity);
    }

    public void updateCoupon(Coupon coupon) throws ApplicationException {
        validateCoupon(coupon);
        CouponEntity couponEntity = new CouponEntity(coupon);
        this.couponsDal.save(couponEntity);
    }
    public void deleteCoupon(long id) throws ApplicationException {
        this.couponsDal.deleteById(id);
    }

    public ExtendedCoupon getCoupon(long id) throws ApplicationException {
        return couponsDal.getCoupon(id);
    }

    public List<ExtendedCoupon> getAllCoupons() throws ApplicationException {
        return couponsDal.getAllCoupons();

    }

    private void validateCoupon(Coupon coupon) throws ApplicationException {
        validateCouponName(coupon.getName());
        validateCouponDescription(coupon.getDescription());
        validateCouponPrice(coupon.getPrice());
        validateCouponDates(coupon.getStartDate(), coupon.getEndDate());
        validateCouponCompanyId(coupon.getCompanyId());
        validateCouponCategoryId(coupon.getCategoryId());
    }

    private void validateCouponCategoryId(long categoryId) throws ApplicationException {
        if (!categoryLogic.isCategoryExist(categoryId)) {
            throw new ApplicationException(ErrorType.INVALID_CATEGORY_ID);
        }
    }

    private void validateCouponCompanyId(long companyId) throws ApplicationException {
        if (!companyLogic.isCompanyIdExist(companyId)) {
            throw new ApplicationException(ErrorType.COMPANY_ID_DOES_NOT_EXIST);
        }
    }

    private void validateCouponDates(Date start_date, Date end_date) throws ApplicationException {
        if (end_date.before(start_date))
            throw new ApplicationException(ErrorType.DATES_NOT_VALID);

    }

    private void validateCouponPrice(float price) throws ApplicationException {
        if (price <= 0) {
            throw new ApplicationException(ErrorType.COUPON_PRICE_TOO_LOW);
        }
        if (price > 300) {
            throw new ApplicationException(ErrorType.COUPON_PRICE_TOO_HIGH);
        }
    }

    private void validateCouponDescription(String description) throws ApplicationException {
        if (description.length() < 10) {
            throw new ApplicationException(ErrorType.COUPON_DESCRIPTION_TOO_SHORT);
        }
        if (description.length() > 100) {
            throw new ApplicationException(ErrorType.COUPON_DESCRIPTION_TOO_LONG);
        }
    }

    private void validateCouponName(String name) throws ApplicationException {
        if (name.length() < 4) {
            throw new ApplicationException(ErrorType.COUPON_NAME_TOO_SHORT);
        }
        if (name.length() > 15) {
            throw new ApplicationException(ErrorType.COUPON_NAME_TOO_LONG);
        }
    }

    boolean isCouponExist(long id) throws ApplicationException {
        return this.couponsDal.existsById(id);
    }

    public List<ExtendedCoupon> getCouponsByCategoryId(long categoryId) throws ApplicationException {
        return couponsDal.getCouponsByCategoryId(categoryId);
    }

    public List<ExtendedCoupon> getCouponsByCompanyId(long companyId) throws ApplicationException {
        return this.couponsDal.getCouponsByCompanyId(companyId);
    }

    public List<ExtendedCoupon> getCouponsByMaxPrice(float maxPrice) throws ApplicationException {
        return this.couponsDal.getCouponsByMaxPrice(maxPrice);
    }
    public List<ExtendedCoupon> getByDateRange(java.util.Date startDate, java.util.Date endDate) throws ApplicationException {
        return this.couponsDal.getByDateRange(startDate,endDate);
    }

//    public void deleteExpiredCoupons() throws ApplicationException {
//        couponsDal.deleteExpiredCoupons();

}

