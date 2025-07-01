package com.itheima.tlias.service.impl;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.EmpExpr;
import com.itheima.tlias.bean.EmpQueryParam;
import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.mapper.EmpExprMapper;
import com.itheima.tlias.mapper.EmpMapper;
import com.itheima.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public PageResult page(EmpQueryParam param) {
        Integer start = (param.getPage() - 1) * param.getPageSize();
        Long total = empMapper.count(param.getName(), param.getGender(), param.getBegin(), param.getEnd());
        List<Emp> rows = empMapper.list(start, param.getPageSize(), param.getName(), 
                                    param.getGender(), param.getBegin(), param.getEnd());
        return new PageResult(total, rows);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(exprList != null && !exprList.isEmpty()){
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public void update(Emp emp) {
        empMapper.updateById(emp);
    }

    @Override
    public void delete(Integer id) {
        empMapper.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }
}