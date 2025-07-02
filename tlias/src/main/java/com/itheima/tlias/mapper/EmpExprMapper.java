package com.itheima.tlias.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itheima.tlias.bean.EmpExpr;

@Mapper
public interface EmpExprMapper {

    @Insert("<script>" +
            "INSERT INTO emp_expr(emp_id, company, position, start_date, end_date, description) " +
            "VALUES " +
            "<foreach collection='exprList' item='expr' separator=','>" +
            "(#{expr.empId}, #{expr.company}, #{expr.position}, #{expr.startDate}, #{expr.endDate}, #{expr.description})" +
            "</foreach>" +
            "</script>")
    void insertBatch(List<EmpExpr> exprList);

    @Delete("<script>" +
            "DELETE FROM emp_expr WHERE emp_id IN " +
            "<foreach collection='empIds' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    void deleteByEmpIds(List<Integer> empIds);

    @Select("SELECT * FROM emp_expr WHERE emp_id = #{id} ORDER BY start_date DESC")
    List<EmpExpr> getByEmpId(Integer id);
}