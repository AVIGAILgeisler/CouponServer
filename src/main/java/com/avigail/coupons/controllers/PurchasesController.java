package com.avigail.coupons.controllers;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dto.ExtendedPurchase;
import com.avigail.coupons.dto.Purchase;
import com.avigail.coupons.logic.PurchaseLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {
    private PurchaseLogic purchaseLogic;

    @Autowired
    public PurchasesController(PurchaseLogic purchaseLogic) {
        this.purchaseLogic = purchaseLogic;
    }

    @PostMapping
    public void addPurchase(@RequestBody Purchase purchase) throws ApplicationException {
         this.purchaseLogic.addPurchase(purchase);
    }

    @PutMapping
    public void updatePurchase(@RequestBody Purchase purchase) throws ApplicationException {
        this.purchaseLogic.updatePurchase(purchase);
    }
    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable ("id") long id) throws ApplicationException {
        this.purchaseLogic.deletePurchase(id);
    }
    @GetMapping("/byCompanyId")
    public List<ExtendedPurchase> getPurchasesByCompanyId(@RequestParam ("companyId")Long companyId) throws ApplicationException {
        return this.purchaseLogic.getPurchasesByCompanyId(companyId);
    }
    @GetMapping("/byUserId")
    public List<ExtendedPurchase> getPurchasesByUserId(@RequestParam ("userId")long userId) throws ApplicationException {
        return this.purchaseLogic.getPurchasesByUserId(userId);
    }
    @GetMapping("/byCategoryId")
    public List<ExtendedPurchase> getPurchasesByCategoryId(@RequestParam ("categoryId")long CategoryId) throws ApplicationException {
        return this.purchaseLogic.getPurchasesByCategoryId(CategoryId);
    }
    @GetMapping("/byDateRange")
    public List<ExtendedPurchase> getPurchasesByDateRange(@RequestParam ("startDate")java.util.Date startDate, @RequestParam ("endDate")java.util.Date endDate) throws ApplicationException {
        return this.purchaseLogic.getPurchasesByDateRange(startDate,endDate);
    }
    @GetMapping
    public List<ExtendedPurchase> getAllPurchase() throws ApplicationException {
        return this.purchaseLogic.getAllPurchase();
    }

    @GetMapping("/{id}")
    public ExtendedPurchase getPurchase(@PathVariable ("id") long id) throws ApplicationException {
        return this.purchaseLogic.getPurchase(id);
    }
}
