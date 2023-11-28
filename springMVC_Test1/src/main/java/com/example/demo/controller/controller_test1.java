package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/test1")
public class controller_test1 {
    @RequestMapping("/sayhi")
    public String sayhi() {
        return "Hello";
    }
}
