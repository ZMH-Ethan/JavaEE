package com.java.Ethan.model;

import com.java.Ethan.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Users {
    @Bean(name={"u1"})
    public User user1() {
        User user = new User();
        user.setId(1);
        return user;
    }
}

