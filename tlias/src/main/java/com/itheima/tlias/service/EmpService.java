package com.itheima.tlias.service;

import com.itheima.tlias.bean.Emp;
import com.itheima.tlias.bean.PageResult;

import java.time.LocalDate;

public interface EmpService {

    /**
     * 分页查询员工信息
     * @param page 当前页码
     * @param pageSize 每页记录数
     * @param name 员工姓名
     * @param gender 员工性别
     * @param begin 入职日期开始时间
     * @param end 入职日期结束时间
     * @return 分页结果
     */
    PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 根据员工 ID 删除员工
     * @param id 员工 ID
     */
    void deleteById(Integer id);

    /**
     * 新增员工
     * @param emp 员工信息
     */
    void save(Emp emp);

    /**
     * 根据员工 ID 查询员工信息
     * @param id 员工 ID
     * @return 员工信息
     */
    Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp 员工信息
     */
    void update(Emp emp);
}