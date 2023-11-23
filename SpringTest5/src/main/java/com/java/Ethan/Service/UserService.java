package com.java.Ethan.Service;

import com.java.Ethan.Model.User;
import com.java.Ethan.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser() {
        return userRepository.getUser();
    }
}
