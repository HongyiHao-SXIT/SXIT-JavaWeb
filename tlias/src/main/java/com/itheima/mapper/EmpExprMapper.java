package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertEmpExpr(List<EmpExpr> exprList);
     void deleteByEmpIds(List<Integer> ids);
    @Select("select * from emp_expr where emp_id = #{id}")
    List<EmpExpr> getEmpId(Integer id);
}
