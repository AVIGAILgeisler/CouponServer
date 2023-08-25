//package com.avigail.coupons.test;
//
//import com.avigail.coupons.exception.ApplicationException;
//import com.avigail.coupons.dto.Category;
//import com.avigail.coupons.logic.CategoryLogic;
//
//import java.util.List;
//
//public class TestCategory {
//    public static void main(String[] args) throws ApplicationException {
//        CategoryLogic categoryLogic = new CategoryLogic();
//
//
//        Category category1 = new Category("food");
//        Category category2 = new Category("movie");
//        Category category3 = new Category("games");
//        Category category4 = new Category("attractions");
//
//
//        try {
//            categoryLogic.addCategory(category1);
//            categoryLogic.addCategory(category2);
//            categoryLogic.addCategory(category3);
//            categoryLogic.addCategory(category4);
//
//
//            Category category = categoryLogic.getCategory(2);
//            category.setName("movies");
//            categoryLogic.updateCategory(category);
////            categoryLogic.deleteCategory(3);
//
//            List<Category> categories = categoryLogic.getAllCategories();
//            for (int i = 0; i < categories.size(); i++) {
//                System.out.println(categories.get(i));
//            }
//
//        } catch (ApplicationException e) {
//            e.printStackTrace();
//        }
//    }
//}

