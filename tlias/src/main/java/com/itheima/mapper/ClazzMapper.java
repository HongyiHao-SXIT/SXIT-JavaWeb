package com.itheima.mapper;


import com.itheima.pojo.Clazz;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> list(String name, LocalDate begin, LocalDate end);

    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into clazz(name,room,begin_Date,end_Date,master_id,subject,update_time)" +
            "values (#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{updateTime})")
    void save(Clazz clazz);

    @Select("select*from clazz where id =#{id}")
    Clazz getById(Integer id);

    void updateById(Clazz clazz);

    @Select("select * from clazz")
    List<Clazz> lists();
}