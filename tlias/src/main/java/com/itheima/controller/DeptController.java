package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        List<Dept> depts=deptService.list();
            return Result.success(depts);
        }
        @DeleteMapping
    public Result delete(Integer id){
        Boolean flag =deptService.deleteById(id);
            if (flag) {
                return Result.success();
            }
            return Result.error("删除失败");
        }

@PostMapping
public Result save(@RequestBody Dept dept){
    System.out.println("新增部门, dept=" + dept);
    deptService.save(dept);
    return Result.success();
}

@GetMapping("/{id}")
public Result getById(@PathVariable Integer id){
    System.out.println("根据ID查询, id=" + id);
    Dept dept = deptService.getById(id);
    return Result.success(dept);
}

@PutMapping
public Result update(@RequestBody Dept dept){
    System.out.println("修改部门, dept=" + dept);
    deptService.update(dept);
    return Result.success();
}
}

