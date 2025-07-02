package com.itheima.tlias.controller;

import com.itheima.tlias.bean.Clazz;
import com.itheima.tlias.bean.ClazzQueryParam;
import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.bean.Result;
import com.itheima.tlias.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

  @GetMapping
    public Result page(ClazzQueryParam queryParam) {
        PageResult pageResult = clazzService.page(queryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        clazzService.AddClass(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success();
    }


    @GetMapping("/list")
    public Result list() {
        List<Clazz> list = clazzService.list();
        return Result.success(list);
    }
}