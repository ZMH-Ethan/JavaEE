package com.example.demo.dao;

import com.example.demo.model.Articleinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;
    @Test
    void getAll() {
        List<Articleinfo> list = articleMapper.getAll();
        System.out.println(list);
    }
}