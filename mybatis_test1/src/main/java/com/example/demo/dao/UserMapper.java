package com.example.demo.dao;

import com.example.demo.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper  //数据持久层的标志
public interface UserMapper {
    List<Userinfo> getAll();
}