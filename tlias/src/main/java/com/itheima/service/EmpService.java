package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> list();
    
    LoginInfo login(Emp emp);
}