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
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        Dept dept = deptMapper.getById(id);
        if (dept == null) {
            throw new IllegalArgumentException("部门不存在，无法删除");
        }

        long employeeCount = deptMapper.countByDeptId(id);
        if (employeeCount > 0) {
            throw new IllegalArgumentException("部门下存在" + employeeCount + "名员工，无法删除");
        }

        deptMapper.deleteById(id, LocalDateTime.now());
    }

}