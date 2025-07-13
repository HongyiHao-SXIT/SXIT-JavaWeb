package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> list() {
        List<Dept> depts=deptMapper.list();
        return depts;
    }

    @Override
    public Boolean deleteById(Integer id) {
        int rows= deptMapper.deleteById(id);
        if (rows > 0) {
            return true;
        }
        return false;
    }
    @Override
    public void save(Dept dept) {
    dept.setCreateTime(LocalDateTime.now());
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.insert(dept);
    }
    @Override
    public Dept getById(Integer id) {
    return deptMapper.getById(id);
}
@Override
public void update(Dept dept) {
    //补全基础属性
    dept.setUpdateTime(LocalDateTime.now());
    //保存部门
    deptMapper.update(dept);
}
}