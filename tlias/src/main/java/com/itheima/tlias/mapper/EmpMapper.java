package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @param name 员工姓名
     * @param gender 员工性别
     * @param begin 入职日期开始时间
     * @param end 入职日期结束时间
     * @return 总记录数
     */
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

    /**
     * 查询当前页数据
     * @param start 起始索引
     * @param pageSize 每页记录数
     * @param name 员工姓名
     * @param gender 员工性别
     * @param begin 入职日期开始时间
     * @param end 入职日期结束时间
     * @return 当前页数据
     */
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

    /**
     * 根据员工 ID 删除员工
     * @param id 员工 ID
     */
    @Delete("delete from emp where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增员工
     * @param emp 员工信息
     */
    @Insert("insert into emp(username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values(#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 根据员工 ID 查询员工信息
     * @param id 员工 ID
     * @return 员工信息
     */
    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id where e.id = #{id}")
    Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp 员工信息
     */
    @Update("update emp set username = #{username}, password = #{password}, name = #{name}, gender = #{gender}, phone = #{phone}, " +
            "job = #{job}, salary = #{salary}, image = #{image}, entry_date = #{entryDate}, dept_id = #{deptId}, update_time = #{updateTime} " +
            "where id = #{id}")
    void updateById(Emp emp);
}