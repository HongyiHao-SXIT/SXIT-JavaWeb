package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    Page<Emp> page(String name, Integer gender, LocalDate begin, LocalDate end);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp (username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time)" +
            " values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);



    void deleteById(List<Integer> ids);

    @Select("select * from emp where id = #{id}")
    Emp getInfo(Integer id);


    void update(Emp emp);
    @Select("select * from emp")
    List<Emp> list();

   @Select("select * from emp where username = #{username} and password = #{password}")
    Emp loginInfo(Emp emp);
}