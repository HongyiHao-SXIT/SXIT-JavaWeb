package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface  StudentMapper{

    List<Student> list(String name, Number degree, String clazzId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into student(name,no,gender,phone,degree,clazz_id,student.id_card,is_college,address,graduation_date,update_time) " +
            "values (#{name},#{no},#{gender},#{phone},#{degree},#{clazzId},#{idCard},#{isCollege},#{address},#{graduationDate},#{updateTime})")
    void save(Student student);

   @Select("select * from student where id = #{id}")
    Student getById(Integer id);

    void updateById(Student student);

    List<Object> updateViolation(Integer id, Integer score);

    void deleteByIds(List<Integer> ids);

    List<Map<String, Object>> countStudentClazzData();
}
