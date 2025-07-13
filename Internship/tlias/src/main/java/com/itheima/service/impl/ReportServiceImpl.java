package com.itheima.service.impl;

import com.itheima.mapper.ReportMapper;
import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>>list = reportMapper.getEmpJobData();
        log.info("查询结果：{}",list);
        List<Object>jobList= list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object>dataList= list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList,dataList);
    }
    @Override
    public List<Map> getEmpGenderData() {
        return reportMapper.getEmpGenderData();
    }
    @Override
    public List<Map> countByDegree() {
        return reportMapper.getEmpstudentDegreeData();
    }
    @Override
    public ClazzOption getStudentCountData() {
        List<Map<String,Object>> List = reportMapper.countStudentClazzData();
        List<Object> clazzList = List.stream().map(dataMap -> dataMap.get("clazzId")).toList();
        List<Object> dataList = List.stream().map(dataMap -> dataMap.get("total")).toList();
        return new ClazzOption(clazzList, dataList);
    }
}
