package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        Page<Emp> empPage = empMapper.page(name, gender, begin, end);
        return new PageResult(empPage.getTotal(), empPage.getResult());
    }
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.stream().forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertEmpExpr(exprList);
        }
    }
    @Transactional
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteById(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        Emp emp = empMapper.getInfo(id);
        List<EmpExpr> exprList = empExprMapper.getEmpId(id);
        emp.setExprList(exprList);
        return emp;
    }

   @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.stream().forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insertEmpExpr(exprList);
        }
    }

    @Override
    public List<Emp> list() {
        return empMapper.list();
    }
        @Override
    public LoginInfo login(Emp emp) {
        Emp emplogin = empMapper.loginInfo(emp);
        if (emplogin != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", emplogin.getId());
            claims.put("username", emplogin.getUsername());
            String token = JwtUtils.generateJwt(claims);
            LoginInfo loginInfo = new LoginInfo(emplogin.getId(), emplogin.getUsername(), emplogin.getName(), token);
            return loginInfo;
        }
        return null;
    }

}