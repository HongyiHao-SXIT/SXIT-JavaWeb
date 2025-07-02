package com.itheima.tlias.service.impl;

import com.itheima.tlias.mapper.StudentMapper;
import com.itheima.tlias.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Map<String, Object>> clazzStudentCount() {
        List<Map<String, Object>> rawList = studentMapper.countByClazz();
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Map<String, Object> map : rawList) {
            Map<String, Object> newMap = new HashMap<>();
            newMap.put("name", map.get("clazzName"));
            newMap.put("value", map.get("count"));
            resultList.add(newMap);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> studentDegreeStatistics() {
        List<Map<String, Object>> rawList = studentMapper.countByDegree();
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Map<String, Object> map : rawList) {
            Map<String, Object> newMap = new HashMap<>();
            newMap.put("name", map.get("degreeName"));
            newMap.put("value", map.get("count"));
            resultList.add(newMap);
        }
        return resultList;
    }
}
