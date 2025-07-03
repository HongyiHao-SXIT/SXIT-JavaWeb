package com.itheima.tlias.controller;

import com.itheima.tlias.bean.ClazzSizeOption;
import com.itheima.tlias.bean.Result;
import com.itheima.tlias.service.ReportService;
import com.itheima.tlias.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result empJobData() {
        Map<String, Object> result = statisticsService.empJobData();
        return Result.success(result);
    }

    @GetMapping("/empGenderData")
    public Result empGenderData() {
        List<Map<String, Object>> result = statisticsService.empGenderData();
        return Result.success(result);
    }


    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        List<Map<String, Object>> list = reportService.getStudentDegreeData();
        return Result.success(list);
    }

    @GetMapping("/studentCountData")
    public Result getClazzData() {
        ClazzSizeOption clazzSizeOption = reportService.getClazzData();
        return Result.success(clazzSizeOption);
    }
}