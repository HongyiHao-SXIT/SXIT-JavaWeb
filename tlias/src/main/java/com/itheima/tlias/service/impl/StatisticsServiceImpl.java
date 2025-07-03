package com.itheima.tlias.service.impl;

import com.itheima.tlias.mapper.EmpMapper;
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
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Map<String, Object> empJobData() {
        List<Map<String, Object>> rawList = empMapper.countByJob();

        List<String> jobList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();

        for (Map<String, Object> map : rawList) {
            jobList.add((String) map.get("pos"));
            dataList.add(((Long) map.get("total")).intValue());
        }

        Map<String, Object> result = new HashMap<>();
        result.put("jobList", jobList);
        result.put("dataList", dataList);

        return result;
    }

    @Override
    public List<Map<String, Object>> empGenderData() {
        List<Map<String, Object>> rawList = empMapper.countByGender();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> map : rawList) {
            Integer gender = (Integer) map.get("gender");
            Long count = (Long) map.get("count");

            Map<String, Object> genderMap = new HashMap<>();
            genderMap.put("name", gender == 1 ? "男性员工" : "女性员工");
            genderMap.put("value", count);
            result.add(genderMap);
        }

        return result;
    }

    @Override
    public List<Map<String, Object>> clazzStudentCount() {
        return studentMapper.countByClazz();
    }

    @Override
    public List<Map<String, Object>> studentDegree() {
        return studentMapper.countByDegree();
    }
}