package com.java.Ethan;

import com.java.Ethan.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = (User) context.getBean("u1");
        System.out.println(user.toString());
    }
}
