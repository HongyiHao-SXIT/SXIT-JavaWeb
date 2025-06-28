package com.itheima.tlias.service.impl;

import com.itheima.tlias.bean.Dept;
import com.itheima.tlias.mapper.Deptmapper;
import com.itheima.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private Deptmapper deptMapper;

    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    public void save(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    public void updateById(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }
}