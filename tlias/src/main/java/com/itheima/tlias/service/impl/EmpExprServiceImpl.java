package com.itheima.tlias.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.itheima.tlias.mapper.EmpExprMapper;
import com.itheima.tlias.service.EmpExprService;

public class EmpExprServiceImpl implements EmpExprService {
    @Autowired
    private EmpExprMapper empExprMapper;
}
