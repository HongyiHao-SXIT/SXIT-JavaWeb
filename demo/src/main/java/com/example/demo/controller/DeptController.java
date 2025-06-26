package com.example.demo.controller;

import com.example.demo.entity.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {

    /**
     * 新增部门
     *
     * @param dept
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Dept dept) {
        System.out.println("新增部门:" + dept);
        return Result.success();
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        System.out.println("删除部门:" + id);
        if (id == 0) {
            return Result.error("id不合法");
        }
        return Result.success();
    }

    /**
     * 根据id修改部门
     *
     * @param dept
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改部门:" + dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result getById(@PathVariable("id") Integer id) {
        System.out.println("根据id查询部门:" + id);
        Dept dept = new Dept();
        dept.setId(id);
        dept.setName("人事部");
        dept.setUser("张三");
        return Result.success(dept);
    }

    @GetMapping
    public Result list() {
        System.out.println("查询所有部门");

        //创建一个空集合
        List<Dept> list = new ArrayList<>();

        //创建三个部门对象
        Dept dept1 = new Dept();
        dept1.setId(1);
        dept1.setName("人事部");
        dept1.setUser("张三");

        Dept dept2 = new Dept();
        dept2.setId(2);
        dept2.setName("教研部");
        dept2.setUser("李四");


        Dept dept3 = new Dept();
        dept3.setId(3);
        dept3.setName("财务部");
        dept3.setUser("王五");

        //将三个部门对象添加到集合中
        list.add(dept1);
        list.add(dept2);
        list.add(dept3);


        return Result.success(list);
    }

}