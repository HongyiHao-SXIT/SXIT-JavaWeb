package com.hw3.hw3.mapper;

import com.hw3.hw3.entity.Emp;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface EmpMapper {

    @Select("SELECT * FROM tb_emp")
    List<Emp> selectAll();

    @Select("SELECT * FROM tb_emp WHERE id = #{id}")
    Emp selectById(@Param("id") Integer id);

    @Insert("INSERT INTO tb_emp (username, password, name, gender, image, job, entrydate, create_time, update_time) " +
            "VALUES (#{username}, #{password}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{createTime}, #{updateTime})")
    int insertEmp(Emp emp);
    
    @Delete("DELETE FROM tb_emp WHERE id = #{id}")
    int deleteEmp(@Param("id") Integer id);

    @Update("UPDATE tb_emp SET username = #{username}, password = #{password}, name = #{name}, gender = #{gender}, " +
            "image = #{image}, job = #{job}, entrydate = #{entrydate}, update_time = #{updateTime} WHERE id = #{id}")
    int updateEmp(Emp emp);
}
