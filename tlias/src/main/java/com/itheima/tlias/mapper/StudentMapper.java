package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    @Insert("INSERT INTO student (name, no, gender, phone, degree, id_card, is_college, " +
            "address, graduation_date, violation_count, violation_score, clazz_id, create_time, update_time) " +
            "VALUES (#{name}, #{no}, #{gender}, #{phone}, #{degree}, #{idCard}, #{isCollege}, " +
            "#{address}, #{graduationDate}, #{violationCount}, #{violationScore}, #{clazzId}, #{createTime}, #{updateTime})")
    void insert(Student student);

    @Delete("<script>" +
            "DELETE FROM student WHERE id IN " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'> " +
            "#{id} " +
            "</foreach>" +
            "</script>")
    void deleteByIds(List<Integer> ids);

    @Update("UPDATE student SET name=#{name}, no=#{no}, gender=#{gender}, phone=#{phone}, " +
            "degree=#{degree}, id_card=#{idCard}, is_college=#{isCollege}, address=#{address}, " +
            "graduation_date=#{graduationDate}, clazz_id=#{clazzId}, update_time=#{updateTime} " +
            "WHERE id=#{id}")
    void update(Student student);

    @Select("SELECT s.*, c.name AS clazzName " +
            "FROM student s " +
            "LEFT JOIN clazz c ON s.clazz_id = c.id " +
            "WHERE s.id = #{id}")
    Student getById(Integer id);

    @Select("<script>" +
            "SELECT s.*, c.name AS clazzName " +
            "FROM student s " +
            "LEFT JOIN clazz c ON s.clazz_id = c.id " +
            "<where> " +
            "<if test='name != null and name.trim() != \"\"'> AND s.name LIKE CONCAT('%', #{name}, '%') </if> " +
            "<if test='degree != null'> AND s.degree = #{degree} </if> " +
            "<if test='clazzId != null'> AND s.clazz_id = #{clazzId} </if> " +
            "</where> " +
            "LIMIT #{start}, #{pageSize} " +
            "</script>")
    List<Student> list(Integer start, Integer pageSize, String name, Integer degree, Integer clazzId);

    @Select("<script>" +
            "SELECT COUNT(*) FROM student " +
            "<where> " +
            "<if test='name != null and name.trim() != \"\"'> AND name LIKE CONCAT('%', #{name}, '%') </if> " +
            "<if test='degree != null'> AND degree = #{degree} </if> " +
            "<if test='clazzId != null'> AND clazz_id = #{clazzId} </if> " +
            "</where> " +
            "</script>")
    Long count(String name, Integer degree, Integer clazzId);

    @Select("SELECT * FROM student")
    List<Student> listAll();

    @Update("UPDATE student SET violation_count = violation_count + 1, " +
            "violation_score = violation_score + #{score}, update_time = NOW() " +
            "WHERE id = #{id}")
    void updateViolation(@Param("id") Integer id, @Param("score") Integer score);

    @Select("SELECT c.name AS name, COUNT(s.id) AS value " +
            "FROM clazz c " +
            "LEFT JOIN student s ON c.id = s.clazz_id " +
            "GROUP BY c.name " +
            "ORDER BY c.id")
    List<Map<String, Object>> countByClazz();

    @Select("SELECT " +
            "CASE degree " +
            "WHEN 1 THEN '初中' " +
            "WHEN 2 THEN '高中' " +
            "WHEN 3 THEN '大专' " +
            "WHEN 4 THEN '本科' " +
            "WHEN 5 THEN '硕士' " +
            "WHEN 6 THEN '博士' " +
            "END AS degreeName, " +
            "COUNT(*) AS count " +
            "FROM student " +
            "GROUP BY degree")
    List<Map<String, Object>> getStudentDegreeData();

    @Select("SELECT c.name AS clazz, COUNT(s.id) AS num " +
            "FROM clazz c " +
            "LEFT JOIN student s ON c.id = s.clazz_id " +
            "GROUP BY c.name " +
            "ORDER BY c.id")
    List<Map<String, Object>> getClazzData();

    @Select("SELECT " +
        "CASE degree " +
        "WHEN 1 THEN '初中' " +
        "WHEN 2 THEN '高中' " +
        "WHEN 3 THEN '大专' " +
        "WHEN 4 THEN '本科' " +
        "WHEN 5 THEN '硕士' " +
        "WHEN 6 THEN '博士' " +
        "END AS degreeName, " +
        "COUNT(*) AS count " +
        "FROM student " +
        "GROUP BY degree")
List<Map<String, Object>> countByDegree();
}
