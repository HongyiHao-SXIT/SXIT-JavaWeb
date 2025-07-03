package com.itheima.tlias.service;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.LoginInfo;

import java.util.List;

public interface EmpService {
    
    public List<Emp> list();
    void save(Emp emp);
    void deleteByIds(List<Integer> ids);
    Emp getInfo(Integer id);
    void update(Emp emp);
    LoginInfo login(Emp emp);
}