package com.example.demo.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Userinfo {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private Date createTime;
    private Date updateTime;
    private List<Articleinfo> aLsit;
}
