package com.avigail.coupons.controllers;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dto.User;
import com.avigail.coupons.dto.UserLoginData;
import com.avigail.coupons.logic.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UserLogic userLogic;

    @Autowired
    public UsersController(UserLogic userLogic) {
        this.userLogic = userLogic;
    }

    @PostMapping
    public void addUser(@RequestBody User user) throws ApplicationException {
        this.userLogic.addUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) throws ApplicationException {
        this.userLogic.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) throws ApplicationException {
        this.userLogic.deleteUser(id);
    }
    @GetMapping("/byCompanyId")
    public List<User> getUsersByCompanyId(@RequestParam ("companyId")long companyId) throws ApplicationException {
        return this.userLogic.getUsersByCompanyId(companyId);
    }

    @GetMapping
    public List<User> getAllUser() throws ApplicationException {
        return this.userLogic.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id) throws ApplicationException {
        return this.userLogic.getUser(id);
    }
    @PostMapping("/login")
    public String login(@RequestBody UserLoginData userLoginData) throws ApplicationException {
       return this.userLogic.login(userLoginData);
    }

}
    
