package com.itheima.tlias.controller;

import com.itheima.tlias.service.EmpService;
import com.itheima.tlias.service.impl.EmpServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.tlias.bean.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result save(@RequestBody Emp emp){
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        empService.deleteByIds(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }

    @GetMapping
    public Result list(@RequestParam(required = false) String name, 
                    @RequestParam(required = false) Integer gender,
                    @RequestParam(required = false) LocalDate begin,
                    @RequestParam(required = false) LocalDate end,
                    @RequestParam Integer page, 
                    @RequestParam Integer pageSize) {
        PageResult pageResult = ((EmpServiceImpl)empService).pageByParams(name, gender, begin, end, page, pageSize);
        return Result.success(pageResult);
    }

    @GetMapping("/list")
    public Result listAll() {
    List<Emp> empList = empService.list();
    return Result.success(empList);
    }

}