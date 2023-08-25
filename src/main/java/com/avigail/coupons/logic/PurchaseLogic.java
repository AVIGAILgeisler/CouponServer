package com.avigail.coupons.logic;

import com.avigail.coupons.dto.Coupon;
import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dal.IPurchasesDal;
import com.avigail.coupons.dto.ExtendedPurchase;
import com.avigail.coupons.dto.Purchase;
import com.avigail.coupons.entities.PurchaseEntity;
import com.avigail.coupons.enums.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseLogic {
    private IPurchasesDal purchasesDal;
    private CouponLogic couponLogic;
    private UserLogic userLogic;

    @Autowired
    public PurchaseLogic(IPurchasesDal purchasesDal, CouponLogic couponLogic, UserLogic userLogic) {
        this.purchasesDal = purchasesDal;
        this.couponLogic = couponLogic;
        this.userLogic = userLogic;
    }

    public void addPurchase(Purchase purchase) throws ApplicationException {
        validatePurchase(purchase);
        PurchaseEntity purchaseEntity=new PurchaseEntity(purchase);
        this.purchasesDal.save(purchaseEntity);
        Coupon coupon= this.couponLogic.getCoupon(purchase.getCouponId());
        coupon.setAmount(coupon.getAmount() - purchase.getAmount());
    }
    public void updatePurchase(Purchase purchase) throws ApplicationException {
        PurchaseEntity purchaseEntity=new PurchaseEntity(purchase);
        this.purchasesDal.save(purchaseEntity);
    }
    public void deletePurchase(long id) throws ApplicationException {
        this.purchasesDal.deleteById(id);
    }
    public ExtendedPurchase getPurchase(long id) throws ApplicationException {
        return purchasesDal.getPurchase(id);
    }
    public List<ExtendedPurchase> getAllPurchase() throws ApplicationException {
        return purchasesDal.getAllPurchase();    }

    private void validatePurchase(Purchase purchase) throws ApplicationException {
        validatePurchaseAmount(purchase.getAmount());
        if (!couponLogic.isCouponExist(purchase.getCouponId())) {
            throw new ApplicationException(ErrorType.INVALID_COUPON_ID, "invalid coupon id " + purchase.getCouponId());
        }
        if (!userLogic.isUserExist(purchase.getUserId())) {
            throw new ApplicationException(ErrorType.INVALID_USER_ID, "invalid user id " + purchase.getUserId());
        }
    }
    private void validatePurchaseAmount(float amount) throws ApplicationException{
        if (amount <= 0) {
            throw new ApplicationException(ErrorType.PURCHASE_AMOUNT_NOT_VALID);
        }
    }
    public List<ExtendedPurchase> getPurchasesByCompanyId(Long companyId) throws ApplicationException{
        return purchasesDal.getPurchasesByCompanyId(companyId);
    }
    public List<ExtendedPurchase> getPurchasesByUserId(long userId) throws ApplicationException{
        return purchasesDal.getPurchasesByUserId(userId);
    }
    public List<ExtendedPurchase> getPurchasesByCategoryId(long CategoryId) throws ApplicationException{
        return purchasesDal.getPurchasesByCategoryId(CategoryId);
    }
    public List<ExtendedPurchase> getPurchasesByDateRange(Date startDate, Date endDate) throws ApplicationException{
        return purchasesDal.getPurchasesByDateRange(startDate,endDate);
    }
}
