package com.java.Ethan.Service;

import com.java.Ethan.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //根据ID获取用户对象
    public User getUser(Integer ID) {
        User user = new User();
        user.setId(ID);
        return user;
    }
}
