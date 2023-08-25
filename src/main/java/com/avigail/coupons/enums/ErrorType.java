package com.avigail.coupons.enums;

public enum ErrorType {
    GENERAL_ERROR("A general error ", 404, false),
    COUPON_PRICE_TOO_HIGH("The price you have chosen for this coupon is too high", 101, false),
    COUPON_PRICE_TOO_LOW("The price you have chosen for this coupon is too low", 102, false),
    COUPON_NAME_TOO_LONG("The name of this coupon is too long", 103, false),
    COUPON_NAME_TOO_SHORT("The name of this coupon is too short", 104, false),
    COUPON_DESCRIPTION_TOO_LONG("The description for this coupon is too long", 105, false),
    COUPON_DESCRIPTION_TOO_SHORT("The description for this coupon is too short", 106, false),
    USER_PASSWORD_TOO_SHORT("Password is too short", 107, false),
    USER_PASSWORD_TOO_LONG("Password is too long", 108, false),
    INVALID_PASSWORD("invalid password", 109, false),
    NAME_TOO_SHORT("Name is too short", 110, false),
    NAME_TOO_LONG("Name is too long", 111, false),
    INVALID_USER("invalid_user", 112, false),
    INVALID_VAT_NUMBER("invalid Vat number", 113, false),
    EMAIL_FORMAT_INVALID("invalid format email", 114, false),
    INVALID_ADDRESS("invalid address", 115, false),
    INVALID_COMPANY_ID("invalid company id", 116, false),
    INVALID_COUPON_ID("invalid coupon id", 117, false),
    INVALID_USER_ID("invalid user id", 118, false),
    DATES_NOT_VALID("dates not valid",119,false),
    INVALID_PHONE_NUMBER("invalid phone number",120,true),
    PURCHASE_AMOUNT_NOT_VALID("purchase amount not valid", 121,false),
    INVALID_CATEGORY_ID("invalid category",122,false ),
    COMPANY_ID_DOES_NOT_EXIST("Company id doesn't exist",123 ,false),
    LOGIN_FAILURE("LOGIN_FAILURE",124 ,true);
    private String errorMessage;
    private int errorNumber;
    private boolean isStackTrace;

    ErrorType(String errorMessage, int errorNumber, boolean isStackTrace) {
        this.errorMessage = errorMessage;
        this.errorNumber = errorNumber;
        this.isStackTrace = isStackTrace;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public boolean isStackTrace() {
        return isStackTrace;
    }

    public void setStackTrace(boolean stackTrace) {
        isStackTrace = stackTrace;
    }
}
