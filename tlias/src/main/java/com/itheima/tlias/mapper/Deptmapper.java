package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Dept;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM dept WHERE deleted = 0 ORDER BY id DESC")
    List<Dept> findAll();

    @Select("SELECT id, name, create_time, update_time, deleted " +
            "FROM dept WHERE id = #{id} AND deleted = 0")
    Dept getById(Integer id);

    @Insert("INSERT INTO dept(name, create_time, update_time, deleted) " +
            "VALUES(#{name}, #{createTime}, #{updateTime}, 0)")
    void insert(Dept dept);

    @Update("UPDATE dept SET name = #{name}, update_time = #{updateTime} " +
            "WHERE id = #{id} AND deleted = 0")
    void update(Dept dept);

    @Update("UPDATE dept SET deleted = 1, update_time = #{updateTime} " +
            "WHERE id = #{id} AND deleted = 0")
    void deleteById(@Param("id") Integer id, @Param("updateTime") LocalDateTime updateTime);

    @Select("SELECT COUNT(*) FROM emp WHERE dept_id = #{deptId} AND deleted = 0")
    long countByDeptId(Integer deptId);
}