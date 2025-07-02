package com.itheima.tlias.service.impl;

import com.itheima.tlias.mapper.StudentMapper;
import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.bean.Student;
import com.itheima.tlias.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult page(Integer page, Integer pageSize, String name, Integer degree, Integer clazzId) {
        Integer start = (page - 1) * pageSize;
        List<Student> studentList = studentMapper.list(start, pageSize, name, degree, clazzId);
        Long total = studentMapper.count(name, degree, clazzId);
        PageResult pageResult = new PageResult();
        pageResult.setTotal(total);
        pageResult.setRows(studentList);
        
        return pageResult;
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void addStu(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void handleViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }

    @Override
    public List<Student> list() {
        return studentMapper.listAll();
    }
}