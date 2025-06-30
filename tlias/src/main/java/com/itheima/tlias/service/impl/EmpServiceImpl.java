package com.itheima.tlias.service.impl;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.mapper.EmpMapper;
import com.itheima.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        // 计算起始索引
        Integer start = (page - 1) * pageSize;

        // 查询总记录数
        Long total = empMapper.count(name, gender, begin, end);

        // 查询当前页数据
        List<Emp> rows = empMapper.list(start, pageSize, name, gender, begin, end);

        return new PageResult(total, rows);
    }

    @Override
    public void deleteById(Integer id) {
        empMapper.deleteById(id);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
    }
}