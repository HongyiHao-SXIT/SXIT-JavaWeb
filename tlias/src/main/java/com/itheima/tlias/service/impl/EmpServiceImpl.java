package com.itheima.tlias.service.impl;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.EmpExpr;
import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.mapper.EmpMapper;
import com.itheima.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult page(Integer page, Integer pageSize, String name, Integer gender, 
                         LocalDate begin, LocalDate end) {
        Integer start = (page - 1) * pageSize;
        Long total = empMapper.count(name, gender, begin, end);
        List<Emp> rows = empMapper.list(start, pageSize, name, gender, begin, end);
        return new PageResult(total, rows);
    }
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }
    }
}