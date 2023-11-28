package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/user1")
public class user_controller_test1 {

    @RequestMapping("/add")
    public User add(User user) {
        return user;
    }

    @RequestMapping("/name")
    public String getname(@RequestParam("n") String name) {
        return name;
    }

    @RequestMapping("/name2")
    public String getname2(@RequestParam(value = "n",required = false) String name) {
        return name;
    }

    @RequestMapping("/add_json")
    public User add2(@RequestBody User user) {
        return user;
    }

    @RequestMapping("/detail/{aid}")
    public Integer detail(@PathVariable("aid") Integer id) {
        return id;
    }

    @RequestMapping("/detail2/{aid}/{name}")
    public String detail2(@PathVariable("aid") Integer aid,@PathVariable("name") String name) {
        return aid+name;
    }

    @RequestMapping("/upload")
    public String upload(@RequestPart("myfile")MultipartFile file) throws IOException {
        //1、生成一个唯一的ID
        String name = UUID.randomUUID().toString().replace("-","");
        //2、得到源文件的后缀名
        name += (file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        String path = "F:\\"+name;
        file.transferTo(new File(path));
        return path;
    }


    //获取Cookie
    @RequestMapping("/cookie")
    public String getcookie(@CookieValue(value = "java",required = false) String a) {
        return a;
    }
}
