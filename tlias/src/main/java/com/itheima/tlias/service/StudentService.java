package com.itheima.tlias.service;

import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.bean.Student;
import java.util.List;

public interface StudentService {

    PageResult page(Integer page, Integer pageSize, String name, Integer degree, Integer clazzId);
    void delete(List<Integer> ids);
    void addStu(Student student);
    Student getById(Integer id);
    void update(Student student);
    void handleViolation(Integer id, Integer score);
    List<Student> list();
}