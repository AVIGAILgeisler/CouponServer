package com.avigail.coupons.test;

//import com.avigail.coupons.dto.Coupon;
//import com.avigail.coupons.logic.CompanyLogic;
//import com.avigail.coupons.logic.CouponLogic;
//
//import java.sql.Date;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class TestCompany {
//    public static void main(String[] args) throws ApplicationException{
//        CompanyLogic companyLogic = new CompanyLogic();
//
//
//        Company company1 = new Company("Amir", 511515555, "Hgilboa 3 Ramat Gan", "026518975", "Amir@Amir.com");
//        Company company2 = new Company("Eden", 511235897, "Mazal Gdi 8", "035710536", "Eden@Eden.com");
//        Company company3 = new Company("Noam", 511514444, "Hmacabi 5", "0775897456", "Noam@Noam.com");
//        Company company4 = new Company("Sagiv", 511232587, "Shoham 72", "046258741", "Sagiv@Sagiv.com");
//
//        try {
//            companyLogic.addCompany(company1);
//            companyLogic.addCompany(company2);
//            companyLogic.addCompany(company3);
//            companyLogic.addCompany(company4);
//
//
//            Company company = companyLogic.getCompany(2);
//            company.setAddress("Mazal Gdi 15");
//            companyLogic.updateCompany(company);
////            companyLogic.deleteCompany(3);
//
//            List<Company> companies = companyLogic.getAllCompanies();
//            for (int i = 0; i < companies.size(); i++) {
//                System.out.println(companies.get(i));
//            }
//
//        } catch (ApplicationException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
