package com.itheima.tlias.service;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.EmpQueryParam;
import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.controller.LoginInfo;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    void save(Emp emp);
    void deleteByIds(List<Integer> ids);
    Emp getInfo(Integer id);
    void update(Emp emp);
    PageResult page(EmpQueryParam empQueryParam);
    LoginInfo login(Emp emp);
}