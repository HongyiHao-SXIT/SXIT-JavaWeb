package com.myb.mybatis.mapper;

import com.myb.mybatis.entity.User;
import com.myb.mybatis.mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testFindAll() {
        List<User> userList = userMapper.findAll();
        System.out.println("查询到数据" + userList);
    }
}