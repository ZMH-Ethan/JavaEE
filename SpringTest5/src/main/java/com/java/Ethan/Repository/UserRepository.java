package com.java.Ethan.Repository;

import com.java.Ethan.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
}
