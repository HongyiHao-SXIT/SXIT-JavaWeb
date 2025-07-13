package com.myb.mybatis.entity;

import lombok.*;

@Data

public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private Integer mathScore;
    private Integer englishScore;
    private String city;
}