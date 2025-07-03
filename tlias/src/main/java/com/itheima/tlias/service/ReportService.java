package com.itheima.tlias.service;


import com.itheima.tlias.bean.ClazzSizeOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Object>> getStudentDegreeData();
    ClazzSizeOption getClazzData();
}