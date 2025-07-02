package com.itheima.tlias.service.impl;

import com.itheima.tlias.mapper.StudentMapper;
import com.itheima.tlias.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public List<Map<String, Object>> clazzStudentCount() {
        return studentMapper.countByClazz();
    }
    
    @Override
    public List<Map<String, Object>> studentDegreeStatistics() {
        return studentMapper.countByDegree();
    }
}