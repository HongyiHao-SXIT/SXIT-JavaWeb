package com.itheima.tlias.service;

import java.util.List;

import com.itheima.tlias.bean.EmpExpr;

public interface EmpExprService {
    
    void insertBatch(List<EmpExpr> exprList);
    void deleteByEmpIds(List<Integer> empIds);
    List<EmpExpr> getByEmpId(Integer id);
}
