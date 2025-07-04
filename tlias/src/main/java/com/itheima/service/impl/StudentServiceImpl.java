package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult page(Integer page, Integer pageSize, String name, Number degree, String clazzId){
        PageHelper.startPage(page, pageSize);
        List<Student> StudentList= studentMapper.list(name, degree, clazzId);
        Page<Student> p = (Page<Student>) StudentList;
        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.save(student);}

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void updateById(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }

    @Override
    public List<Object> updateViolation(Integer id, Integer score) {
       return studentMapper.updateViolation(id, score);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }


}
