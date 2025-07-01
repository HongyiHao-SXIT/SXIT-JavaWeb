package com.itheima.tlias.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.itheima.tlias.bean.Clazz;
import com.itheima.tlias.bean.Result;
import com.itheima.tlias.service.ClazzService;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                      @RequestParam(defaultValue = "10") Integer pageSize,
                      String name, Integer subject, String status) {
        PageInfo<Clazz> pageInfo = clazzService.page(page, pageSize, name, subject, status);
        return Result.success(pageInfo);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

}

