package com.itheima.tlias.controller;

import com.itheima.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.itheima.tlias.bean.*;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) LocalDate end) {
        try {
            PageResult pageResult = empService.page(page, pageSize, name, gender, begin, end);
            return Result.success(pageResult);
        } catch (Exception e) {
            return Result.error("分页查询员工信息失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        empService.delete(id);
        return Result.success();
    }


    @PostMapping
    public Result save(@RequestBody Emp emp){
        empService.save(emp);
        return Result.success();
    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
    PageResult pageResult = empService.page(empQueryParam);
    return Result.success(pageResult);
}
    
}