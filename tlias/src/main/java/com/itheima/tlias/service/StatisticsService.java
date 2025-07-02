package com.itheima.tlias.service;

import java.util.List;
import java.util.Map;

public interface StatisticsService {

    List<Map<String, Object>> clazzStudentCount();
    List<Map<String, Object>> studentDegreeStatistics();
}
