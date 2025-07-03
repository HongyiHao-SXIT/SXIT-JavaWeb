package com.itheima.tlias.service.impl;


import com.itheima.tlias.mapper.StudentMapper;
import com.itheima.tlias.bean.ClazzSizeOption;
import com.itheima.tlias.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();
    }

    @Override
    public ClazzSizeOption getClazzData() {
        List<Map<String, Object>> clazzList = studentMapper.getClazzData();
        List<Object> clazz = clazzList.stream().map(dateMap -> dateMap.get("clazz")).collect(Collectors.toList());
        List<Object> numList = clazzList.stream().map(dateMap -> dateMap.get("num")).collect(Collectors.toList());
        return new ClazzSizeOption(clazz, numList);
    }
}