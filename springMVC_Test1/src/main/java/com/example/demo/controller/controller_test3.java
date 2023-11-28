package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/test3")
public class controller_test3 {

    @RequestMapping("/getname1")
    public String getname1(String name) {
        return "name:" + name;
    }

    @RequestMapping("/getname2")
    public String getname2(String name,Integer age) {
        return "name:" + name + " " + "age:" + age;
    }
}
