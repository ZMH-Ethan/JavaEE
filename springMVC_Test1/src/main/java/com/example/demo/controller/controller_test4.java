package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller_test4 {
    @RequestMapping("/index")
    public String hello() {
        return "hello.html";
    }
}
