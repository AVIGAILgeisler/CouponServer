package com.avigail.coupons.logic;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dal.IUsersDal;
import com.avigail.coupons.dto.User;
import com.avigail.coupons.dto.UserData;
import com.avigail.coupons.dto.UserLoginData;
import com.avigail.coupons.entities.UserEntity;
import com.avigail.coupons.enums.ErrorType;
import com.avigail.coupons.utils.EncryptUtils;
import com.avigail.coupons.utils.JWTUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLogic {
    private IUsersDal usersDal;

    @Autowired
    public UserLogic(IUsersDal usersDal) {
        this.usersDal = usersDal;
    }

    public void addUser(User user) throws ApplicationException {
        validateUserData(user);
        String originalPassword = user.getPassword();
        String encryptedPassword = EncryptUtils.encryptPassword(originalPassword);
        user.setPassword(encryptedPassword);
        UserEntity userEntity = new UserEntity(user);
        this.usersDal.save(userEntity);
    }

    public void updateUser(User user) throws ApplicationException {
        validateUserData(user);
        UserEntity userEntity = new UserEntity(user);
        this.usersDal.save(userEntity);
    }

    public void deleteUser(long id) throws ApplicationException {
        this.usersDal.deleteById(id);
    }

    public User getUser(long id) throws ApplicationException {
        return usersDal.getUser(id);
    }

    public List<User> getAllUsers() throws ApplicationException {
        return usersDal.getAllUsers();
    }

    private void validateUserData(User user) throws ApplicationException {
        validateUserName(user.getUserName());
        validateUserPassword(user.getPassword());
    }

    private void validateUserPassword(String password) throws ApplicationException {
//        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[1-9])[a-zA-Z1-9]+$";
//        Pattern pattern = Pattern.compile(passwordRegex);
        if (password == null) {
            throw new ApplicationException(ErrorType.INVALID_PASSWORD);
        }
//        if (!pattern.matcher(password).matches()){
//            throw new ApplicationException(ErrorType.INVALID_PASSWORD);
//        }
        if (password.length() < 3) {
            throw new ApplicationException(ErrorType.USER_PASSWORD_TOO_SHORT);
        }
        if (password.length() > 15) {
            throw new ApplicationException(ErrorType.USER_PASSWORD_TOO_LONG);
        }
    }

    private void validateUserName(String username) throws ApplicationException {
        if (username.length() < 2) {
            throw new ApplicationException(ErrorType.NAME_TOO_SHORT);
        }
        if (username.length() > 15) {
            throw new ApplicationException(ErrorType.NAME_TOO_LONG);
        }
    }

    boolean isUserExist(long id) throws ApplicationException {
        return this.usersDal.existsById(id);
    }

    public List<User> getUsersByCompanyId(Long companyId) throws ApplicationException {
        return usersDal.getUsersByCompanyId(companyId);
    }

    public String login(UserLoginData userLoginData) throws ApplicationException {
        validateUserName(userLoginData.getUserName());
        validateUserPassword(userLoginData.getPassword());
        //Encrypt Password here
        UserData userData = this.usersDal.login(userLoginData.getUserName(), userLoginData.getPassword());
        if (userData == null) {
            throw new ApplicationException(ErrorType.LOGIN_FAILURE);
        }
        try {
            String token = JWTUtils.createJWT(userData);
            return token;
        } catch (JsonProcessingException e) {
            throw new ApplicationException(ErrorType.LOGIN_FAILURE);
        }
    }
}