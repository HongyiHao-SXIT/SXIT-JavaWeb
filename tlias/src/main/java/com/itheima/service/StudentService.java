package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;

import java.util.List;


public interface StudentService {

    PageResult page(Integer page, Integer pageSize, String name, Number degree, String clazzId);


    void save(Student student);

    Student getById(Integer id);

    void updateById(Student student);

    List<Object> updateViolation(Integer id, Integer score);

    void deleteByIds(List<Integer> ids);
}
