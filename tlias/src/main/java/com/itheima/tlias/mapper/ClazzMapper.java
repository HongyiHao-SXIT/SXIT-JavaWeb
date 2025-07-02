package com.itheima.tlias.mapper;

import com.itheima.tlias.bean.Clazz;
import com.itheima.tlias.bean.ClazzQueryParam;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ClazzMapper {

    @Select({
        "<script>",
        "SELECT * FROM clazz",
        "<where>",
        "  <if test='name != null and name != \"\"'>",
        "    AND name LIKE CONCAT('%', #{name}, '%')",
        "  </if>",
        "</where>",
        "ORDER BY id DESC",
        "</script>"
    })
    List<Clazz> list(@Param("name") ClazzQueryParam queryParam);

    @Select("<script>" +
            "select count(*) from clazz " +
            "<where>" +
            "   <if test='name != null and name.trim() != \"\"'> and name like concat('%',#{name},'%') </if>" +
            "   <if test='begin != null'> and begin_date &gt;= #{begin} </if>" +
            "   <if test='end != null'> and end_date &lt;= #{end} </if>" +
            "</where>" +
            "</script>")
    Long count(String name, String begin, String end);

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