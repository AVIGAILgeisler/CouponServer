package com.avigail.coupons.logic;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.enums.ErrorType;

import java.util.regex.Pattern;

public abstract class GeneralLogic {
    void validateEmailAddressStructure(String emailAddress) throws ApplicationException {
        String email = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(email);
        if (!pat.matcher(emailAddress).matches()) {
            throw new ApplicationException(ErrorType.EMAIL_FORMAT_INVALID);
        }
    }
}
