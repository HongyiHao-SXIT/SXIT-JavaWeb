package com.itheima.tlias.service;

import java.util.List;

import com.itheima.tlias.bean.Dept;

public interface DeptService {

    public List<Dept> findAll();
    public void deleteById(Integer id);
    public void save(Dept dept);
    public Dept getById(Integer id);
    public void updateById(Dept dept);
}