package com.itheima.tlias.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClazzMapper {
    @Select("select * from calzz")
    public List<Clazz> list();
    
    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

}
