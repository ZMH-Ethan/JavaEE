package com.java.Ethan.Controller;

import com.java.Ethan.Model.User;
import com.java.Ethan.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public User getUser() {
        return userService.getUser();
    }
}
