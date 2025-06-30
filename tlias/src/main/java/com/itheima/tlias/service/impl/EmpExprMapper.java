package com.itheima.tlias.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.itheima.tlias.bean.EmpExpr;


@Mapper
public interface EmpExprMapper {

    public void insertBatch(List<EmpExpr> exprList);
}