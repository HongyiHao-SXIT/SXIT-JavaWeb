package com.itheima.tlias.service;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.EmpQueryParam;
import com.itheima.tlias.bean.PageResult;

import java.time.LocalDate;

public interface EmpService {

    public PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    public void save(Emp emp);
    public Emp getById(Integer id);
    public void update(Emp emp);
    public void delete(Integer id);
    public PageResult page(EmpQueryParam empQueryParam);
}