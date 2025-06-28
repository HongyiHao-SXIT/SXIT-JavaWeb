package com.myb.mybatis.mapper;

import com.myb.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    @Select("SELECT * FROM users")
    List<User> findAll();
}