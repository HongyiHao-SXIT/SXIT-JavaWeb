package com.itheima.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
@MapKey("pos")
    List<Map<String, Object>> getEmpJobData();
@MapKey("gender")
    List<Map> getEmpGenderData();
@MapKey("degree")
    List<Map> getEmpstudentDegreeData();

@MapKey("name")
List<Map<String, Object>> countStudentClazzData();

}


