package com.avigail.coupons.dto;

import java.util.Date;

public class ExtendedCoupon extends Coupon{
        private String categoryName;
        private String companyName;

        public ExtendedCoupon(long id, String name, String description, Date startDate, Date endDate, int amount, long categoryId, float price, long companyId, String categoryName, String companyName) {
                super(id, name, description, startDate, endDate, amount, categoryId, price, companyId);
                this.categoryName = categoryName;
                this.companyName = companyName;
        }

        public ExtendedCoupon() {
        }

        public String getCategoryName() {
                return categoryName;
        }

        public String getCompanyName() {
                return companyName;
        }

        @Override
        public String toString() {
                return "ExtendedCoupon{" +super.toString()+
                        "categoryName='" + categoryName + '\'' +
                        ", companyName='" + companyName + '\'' +
                        '}';
        }
}
