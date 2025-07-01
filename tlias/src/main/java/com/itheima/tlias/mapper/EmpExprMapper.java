package com.itheima.tlias.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itheima.tlias.bean.EmpExpr;


@Mapper
public interface EmpExprMapper {

    void insertBatch(List<EmpExpr> exprList);
    void deleteByEmpId(Integer id);
    void deleteByEmpIds(List<Integer> ids);
}