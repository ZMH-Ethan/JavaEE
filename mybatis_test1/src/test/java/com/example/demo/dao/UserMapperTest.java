package com.example.demo.dao;

import com.example.demo.model.Userinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  //不能省略 告诉当前测试程序，目前项目是运行在 SpringBoot容器中
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getAll() {
        List<Userinfo> list = userMapper.getAll();
        System.out.println(list);
    }
}