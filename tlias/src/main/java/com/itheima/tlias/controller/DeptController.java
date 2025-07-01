package com.itheima.tlias.controller;

import com.itheima.tlias.bean.Dept;
import com.itheima.tlias.bean.Result;
import com.itheima.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;  

@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Dept dept) {
        deptService.save(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }
}