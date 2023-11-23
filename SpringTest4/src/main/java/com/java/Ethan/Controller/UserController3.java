package com.java.Ethan.Controller;

import com.java.Ethan.Service.UserService;
import com.java.Ethan.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController3 {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser(Integer ID) {
        return userService.getUser(ID);
    }
}
