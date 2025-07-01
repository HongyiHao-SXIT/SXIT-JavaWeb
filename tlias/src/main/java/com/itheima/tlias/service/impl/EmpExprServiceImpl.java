package com.itheima.tlias.service.impl;

import com.itheima.tlias.bean.EmpExpr;
import com.itheima.tlias.mapper.EmpExprMapper;
import com.itheima.tlias.service.EmpExprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpExprServiceImpl implements EmpExprService {
    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public void insertBatch(List<EmpExpr> exprList) {
        empExprMapper.insertBatch(exprList);
    }

    @Override
    public void deleteByEmpIds(List<Integer> empIds) {
        empExprMapper.deleteByEmpIds(empIds);
    }

    @Override
    public List<EmpExpr> getByEmpId(Integer id) {
        return empExprMapper.getByEmpId(id);
    }
}