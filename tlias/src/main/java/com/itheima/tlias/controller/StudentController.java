package com.itheima.tlias.controller;

import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.bean.Result;
import com.itheima.tlias.bean.Student;
import com.itheima.tlias.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                      @RequestParam(defaultValue = "10") Integer pageSize,
                      String name, Integer degree, Integer clazzId) {
        PageResult pageResult = studentService.page(page, pageSize, name, degree, clazzId);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        studentService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Student student) {
        studentService.addStu(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result handleViolation(@PathVariable Integer id, 
                                @PathVariable Integer score) {
        studentService.handleViolation(id, score);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list() {
        List<Student> list = studentService.list();
        return Result.success(list);
    }
}