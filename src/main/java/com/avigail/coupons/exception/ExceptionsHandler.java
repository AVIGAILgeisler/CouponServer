package com.avigail.coupons.exception;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.avigail.coupons.dto.ErrorBean;
import com.avigail.coupons.enums.ErrorType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Exception handler class
@RestControllerAdvice
public class ExceptionsHandler {

    //	Response - Object in Spring
    @ExceptionHandler
    @ResponseBody
    // Variable name is throwable in order to remember that it handles Exception and Error
    public ErrorBean toResponse(Throwable throwable, HttpServletResponse response) {

        //	ErrorBean errorBean;
        if (throwable instanceof ApplicationException) {

            ApplicationException appException = (ApplicationException) throwable;

            ErrorType errorType = appException.getErrorType();
            int errorNumber = errorType.getErrorNumber();
            String errorMessage = errorType.getErrorMessage();
            String errorName = errorType.getErrorMessage();
            response.setStatus(errorNumber);


//System.out.println(errorNumber);
//System.out.println(errorName);
//appException.printStackTrace();
            ErrorBean errorBean = new ErrorBean(errorNumber, errorName ,errorMessage);
            if(appException.getErrorType().isStackTrace()) {
                appException.printStackTrace();
            }

            return errorBean;
        }

        response.setStatus(600);

        String errorMessage = throwable.getMessage();
        ErrorBean errorBean = new ErrorBean(601, "General error", errorMessage);
        throwable.printStackTrace();

        return errorBean;
    }

}

