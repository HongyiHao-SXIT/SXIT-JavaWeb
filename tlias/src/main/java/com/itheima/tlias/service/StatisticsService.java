package com.itheima.tlias.service;


import java.util.List;
import java.util.Map;

public interface StatisticsService {

    Map<String, Object> empJobData();
    List<Map<String, Object>> empGenderData();
    List<Map<String, Object>> clazzStudentCount();
    List<Map<String, Object>> studentDegree();
}