package com.itheima.tlias.controller;

import com.itheima.tlias.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/clazz-count")
    public List<Map<String, Object>> getClazzStudentCount() {
        return statisticsService.clazzStudentCount();
    }

    @GetMapping("/degree-stats")
    public List<Map<String, Object>> getStudentDegreeStatistics() {
        return statisticsService.studentDegreeStatistics();
    }
}