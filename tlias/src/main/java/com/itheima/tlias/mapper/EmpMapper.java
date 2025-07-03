package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Emp;
import org.apache.ibatis.annotations.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    @Select("SELECT * FROM emp ORDER BY id DESC")
    List<Emp> list();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO emp(username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
        "VALUES (#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    @Delete("DELETE FROM emp WHERE id = #{id}")
    void deleteById(Integer id);

    @Delete("<script>" +
            "DELETE FROM emp WHERE id IN " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    void deleteByIds(@Param("ids") List<Integer> ids);
    
    @Select("SELECT e.*, d.name AS deptName FROM emp e LEFT JOIN dept d ON e.dept_id = d.id WHERE e.id = #{id}")
    Emp getById(Integer id);

    @Update("UPDATE emp SET " +
            "username = #{username}, " +
            "<if test='password != null'>password = #{password},</if>" +
            "name = #{name}, " +
            "gender = #{gender}, " +
            "phone = #{phone}, " +
            "job = #{job}, " +
            "salary = #{salary}, " +
            "image = #{image}, " +
            "entry_date = #{entryDate}, " +
            "dept_id = #{deptId}, " +
            "update_time = #{updateTime} " +
            "WHERE id = #{id}")
    void update(Emp emp);

    @Select("SELECT COUNT(*) FROM emp WHERE dept_id = #{deptId}")
    long countByDeptId(Integer deptId);

    @Select("SELECT COUNT(*) FROM emp WHERE username = #{username}")
    long countByUsername(String username);

    @Select("SELECT * FROM emp WHERE username = #{username} AND password = #{password}")
    Emp getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

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

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);

        @Select("SELECT " +
            "(CASE job WHEN 1 THEN '班主任' " +
            "         WHEN 2 THEN '讲师' " +
            "         WHEN 3 THEN '学工主管' " +
            "         WHEN 4 THEN '教研主管' " +
            "         WHEN 5 THEN '咨询师' " +
            "         ELSE '其他' END) AS pos, " +
            "COUNT(*) AS total " +
            "FROM emp " +
            "GROUP BY job " +
            "ORDER BY total")
    List<Map<String, Object>> countByJob();

    @Select("SELECT gender, COUNT(*) AS count FROM emp GROUP BY gender")
    List<Map<String, Object>> countByGender();
}