package com.itheima.tlias.service;

import java.util.List;

import com.itheima.tlias.bean.Dept;

public interface DeptService {

    public List<Dept> findAll();
    void deleteById(Integer id);
    void save(Dept dept);
    Dept getById(Integer id);
    void update(Dept dept);
}