package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.EmpQueryParam;
import org.apache.ibatis.annotations.*;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("<script>" +
        "SELECT e.*, d.name deptName " +
        "FROM emp e " +
        "LEFT JOIN dept d ON e.dept_id = d.id " +
        "WHERE 1=1 " +
        "<if test='name != null and name != \"\"'>" +
        "AND e.name LIKE CONCAT('%', #{name}, '%') " +
        "</if>" +
         "<if test='gender != null'>" +
        "AND e.gender = #{gender} " +
        "</if>" +
        "<if test='begin != null'>" +
        "AND e.entry_date &gt;= #{begin} " +
         "</if>" +
        "<if test='end != null'>" +
         "AND e.entry_date &lt;= #{end} " +
        "</if>" +
         "</script>")
    List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
        "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Delete("<script>" +
            "DELETE FROM emp WHERE id IN " +
            "<foreach collection='list' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    void deleteByIds(List<Integer> ids);
    
    @Select("SELECT e.*, d.name as deptName FROM emp e LEFT JOIN dept d ON e.dept_id = d.id WHERE e.id = #{id}")
    Emp getById(Integer id);

    @Update("UPDATE emp SET username = #{username}, password = #{password}, name = #{name}, gender = #{gender}, " +
            "phone = #{phone}, job = #{job}, salary = #{salary}, image = #{image}, entry_date = #{entryDate}, " +
            "dept_id = #{deptId}, create_time = #{createTime}, update_time = #{updateTime} WHERE id = #{id}")
    void updateById(Emp emp);

    // 修改方法名
    @Select("<script>" +
        "SELECT e.*, d.name deptName " +
        "FROM emp e " +
        "LEFT JOIN dept d ON e.dept_id = d.id " +
        "WHERE 1=1 " +
        "<if test='name != null and name != \"\"'>" +
        "AND e.name LIKE CONCAT('%', #{name}, '%') " +
        "</if>" +
        "<if test='gender != null'>" +
        "AND e.gender = #{gender} " +
        "</if>" +
        "<if test='begin != null'>" +
        "AND e.entry_date &gt;= #{begin} " +
        "</if>" +
        "<if test='end != null'>" +
        "AND e.entry_date &lt;= #{end} " +
        "</if>" +
        "</script>")
    List<Emp> listByParams(@Param("name") String name, 
                           @Param("gender") Integer gender,
                           @Param("begin") LocalDate begin,
                           @Param("end") LocalDate end);
}