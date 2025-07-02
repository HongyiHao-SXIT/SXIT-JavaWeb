package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Dept;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM dept")
    List<Dept> findAll();

    @Select("SELECT id, name, create_time, update_time FROM dept WHERE id = #{id}")
    Dept getById(Integer id);

    @Insert("INSERT INTO dept(name, create_time, update_time) " +
            "VALUES(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    @Update("UPDATE dept SET name = #{name}, update_time = #{updateTime} " +
            "WHERE id = #{id}")
    void update(Dept dept);


    @Delete("DELETE FROM dept WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT COUNT(*) FROM emp WHERE dept_id = #{deptId}")
    long countByDeptId(Integer deptId);
}