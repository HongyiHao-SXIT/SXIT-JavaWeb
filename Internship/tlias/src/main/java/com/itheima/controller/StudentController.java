package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1")Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize,
                       String name, Number degree, String clazzId){
        log.info("查询请求参数： {}, {}, {}, {}, {}, {}", page, pageSize, name, degree, clazzId);
        PageResult pageResult = studentService.page(page, pageSize, name, degree, clazzId);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("保存请求参数： {}", student);
        studentService.save(student);
        return Result.success();}

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询id为{}的记录", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("更新请求参数： {}", student);
        studentService.updateById(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("更新id为{}的记录的违规次数和违规分数", id);
        studentService.updateViolation(id, score);
        return Result.success();}

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable String ids) {
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        studentService.deleteByIds(idList);
        return Result.success();
    }

}
