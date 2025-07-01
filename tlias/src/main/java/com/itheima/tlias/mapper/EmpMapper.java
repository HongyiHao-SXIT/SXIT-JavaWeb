package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.EmpExpr;
import com.itheima.tlias.bean.EmpQueryParam;
import org.apache.ibatis.annotations.*;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("<script>" +
            "select count(*) from emp e left join dept d on e.dept_id = d.id " +
            "where 1 = 1 " +
            "<if test='name != null and name != \"\"'>" +
            "and e.name like concat('%', #{name}, '%') " +
            "</if>" +
            "<if test='gender != null'>" +
            "and e.gender = #{gender} " +
            "</if>" +
            "<if test='begin != null'>" +
            "and e.entry_date &gt;= #{begin} " +
            "</if>" +
            "<if test='end != null'>" +
            "and e.entry_date &lt;= #{end} " +
            "</if>" +
            "</script>")
    Long count(String name, Integer gender, LocalDate begin, LocalDate end);

    @Select("<script>" +
            "select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id " +
            "where 1 = 1 " +
            "<if test='name != null and name != \"\"'>" +
            "and e.name like concat('%', #{name}, '%') " +
            "</if>" +
            "<if test='gender != null'>" +
            "and e.gender = #{gender} " +
            "</if>" +
            "<if test='begin != null'>" +
            "and e.entry_date &gt;= #{begin} " +
            "</if>" +
            "<if test='end != null'>" +
            "and e.entry_date &lt;= #{end} " +
            "</if>" +
            "limit #{start}, #{pageSize}" +
            "</script>")
    List<Emp> list(Integer start, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    @Delete("delete from emp where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into emp(username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values(#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id where e.id = #{id}")
    Emp getById(Integer id);

    @Update("update emp set username = #{username}, password = #{password}, name = #{name}, gender = #{gender}, phone = #{phone}, " +
            "job = #{job}, salary = #{salary}, image = #{image}, entry_date = #{entryDate}, dept_id = #{deptId}, update_time = #{updateTime} " +
            "where id = #{id}")
    void updateById(Emp emp);

    List<Emp> list(EmpQueryParam empQueryParam);

    void deleteByIds(List<Integer> ids);
}

