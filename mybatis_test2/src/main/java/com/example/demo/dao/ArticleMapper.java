package com.example.demo.dao;

import com.example.demo.model.Articleinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select a.*,u.username from articleinfo a left join userinfo u on a.uid=u.id")
    List<Articleinfo> getAll();

    @Select("select * from articleinfo where uid=#{uid}")
    List<Articleinfo> getListByUid(@Param("uid") Integer uid);

}
