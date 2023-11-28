package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class controller_test2 {
    @RequestMapping(path = "/hi2",method = RequestMethod.GET)
    public String test2hi() {
        return "<h1>hello,test2</h1>";
    }
    @GetMapping("/hi22")
    public String test2post() {
        return "<h1>Hello,PostMapping</h1>";
    }

}
