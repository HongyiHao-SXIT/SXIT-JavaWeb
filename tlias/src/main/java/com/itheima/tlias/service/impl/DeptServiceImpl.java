package com.itheima.tlias.service.impl;

import com.itheima.tlias.bean.Dept;
import com.itheima.tlias.mapper.DeptMapper;
import com.itheima.tlias.mapper.EmpMapper;
import com.itheima.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired 
    private EmpMapper empMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    @Transactional
    public void save(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    @Transactional
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (empMapper.countByDeptId(id) > 0) {
            throw new RuntimeException("删除失败！该部门下有员工，无法直接删除");
        }
        deptMapper.deleteById(id);
    }
}