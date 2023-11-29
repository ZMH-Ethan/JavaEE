package com.example.demo.dao;

import com.example.demo.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    List<Userinfo> getAll();

    Userinfo getUserById(@Param("id") Integer id);

    Userinfo login(@Param("u")String username,@Param("p")String password);

    List<Userinfo> getAllByOrder(@Param("myOrder") String myOrder);

    int delByID(@Param("id") int id);

    int update(Userinfo userinfo);

    int add(Userinfo userinfo);

    int add2(Userinfo userinfo);

    List<Userinfo> getLikeList(@Param("username") String username);

    @Select("select * from userinfo where id=#{id}")
    Userinfo getUserById2(@Param("id") Integer id);
}