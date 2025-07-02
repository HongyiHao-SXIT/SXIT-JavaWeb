package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Clazz;
import com.itheima.tlias.bean.ClazzQueryParam;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ClazzMapper {

        @Select("SELECT * FROM clazz ORDER BY id DESC")
        List<Clazz> list();

        @Select("SELECT COUNT(*) FROM clazz")
        Long count();


    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insert(Clazz clazz);

    @Select("select * from clazz where id = #{id}")
    Clazz getById(Integer id);

    @Update("update clazz set name=#{name}, room=#{room}, begin_date=#{beginDate}, " +
            "end_date=#{endDate}, master_id=#{masterId}, subject=#{subject}, update_time=#{updateTime} " +
            "where id=#{id}")
    void update(Clazz clazz);

    @Select("select * from clazz")
    List<Clazz> listAll();
}