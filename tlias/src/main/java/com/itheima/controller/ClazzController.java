package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end)  {
        log.info("查询请求参数： {}, {}, {}, {}, {}, {}", page, pageSize, name, begin, end
        );

        PageResult pageResult = clazzService.page(page, pageSize,name, begin, end);

        return Result.success(pageResult);
    }

    @DeleteMapping("/{id}")
    public  Result delete(@PathVariable Integer id)
        {
            log.info("删除班级：{}",id);
            clazzService.deleteById(id);
            return Result.success();
        }

    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("保存班级：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("查询班级：{}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("更新班级：{}", clazz);
        clazzService.updateById(clazz);
        return Result.success();
    }


    @GetMapping("/list")
    public Result list() {
        log.info("查询所有班级");
        List<Clazz> list = clazzService.list();
        return Result.success(list);
    }
}
