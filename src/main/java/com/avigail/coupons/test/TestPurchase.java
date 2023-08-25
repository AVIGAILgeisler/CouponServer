//package com.avigail.coupons.test;
//
//import com.avigail.coupons.exception.ApplicationException;
//import com.avigail.coupons.dto.Purchase;
//import com.avigail.coupons.logic.PurchaseLogic;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class TestPurchase {
//    public static void main(String[] args) throws ApplicationException {
//        PurchaseLogic purchaseLogic = new PurchaseLogic();
//        LocalDateTime dateTime = LocalDateTime.now().plusMonths(2);
//        Date date = Date.valueOf(dateTime.toLocalDate());
//
//        Purchase purchase1 = new Purchase(3, 2, 195, date);
//        Purchase purchase2 = new Purchase(2, 3, 150, date);
//        Purchase purchase3 = new Purchase(1, 4, 80, date);
//        Purchase purchase4 = new Purchase(4, 1, 300, date);
//
//
//        try {
//            purchaseLogic.addPurchase(purchase1);
//            purchaseLogic.addPurchase(purchase2);
//            purchaseLogic.addPurchase(purchase3);
//            purchaseLogic.addPurchase(purchase4);
//
//            Purchase purchase = purchaseLogic.getPurchase(2);
//            purchase.setAmount(135);
//            purchaseLogic.updatePurchase(purchase);
////             purchaseLogic.deletePurchase(3);
//
//            List<Purchase> purchases = purchaseLogic.getAllPurchase();
//            for (int i = 0; i < purchases.size(); i++) {
//                System.out.println(purchases.get(i));
//            }
//
//            System.out.println(purchaseLogic.getPurchasesByCompanyId(2));
//            System.out.println(purchaseLogic.getPurchasesByUserId(3));
//            System.out.println(purchaseLogic.getPurchasesByCategoryId(3));
//            System.out.println(purchaseLogic.getPurchasesByUserId(3));
//
//            Date date1 = Date.valueOf(LocalDate.now());
//            Date date2 = Date.valueOf(dateTime.toLocalDate());
//            System.out.println(purchaseLogic.getPurchasesByDateRange(date1, date2));
//
//        } catch (ApplicationException e) {
//            e.printStackTrace();
//        }
//    }
//}
