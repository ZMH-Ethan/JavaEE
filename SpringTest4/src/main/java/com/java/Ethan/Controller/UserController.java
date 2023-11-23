package com.java.Ethan.Controller;

import com.java.Ethan.Service.UserService;
import com.java.Ethan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public User getUser(Integer ID) {
        return userService.getUser(ID);
    }
}
