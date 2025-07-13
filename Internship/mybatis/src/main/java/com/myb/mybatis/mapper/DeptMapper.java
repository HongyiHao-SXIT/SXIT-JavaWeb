package com.myb.mybatis.mapper;

import com.myb.mybatis.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DeptMapper {
    
    /**
     * 根据id查询用户
     * @param id 用户ID
     * @return 用户对象
     */     
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Integer id);

    /**
     * 新增用户
     * @param user 用户对象
     * @return 受影响的行数
     */
    @Insert("INSERT INTO users (name, username, password, age, gender, " +
            "math_score, english_score, city) " +
            "VALUES (#{name}, #{username}, #{password}, #{age}, #{gender}, " +
            "#{mathScore}, #{englishScore}, #{city})")
    int insert(User user);

    /**
     * 根据id删除用户
     * @param id 用户ID
     * @return 受影响的行数
     */
    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteById(Integer id);

    /**
     * 修改用户信息
     * @param user 用户对象
     * @return 受影响的行数
     */
    @Update("UPDATE users SET " +
            "name = #{name}, " +
            "username = #{username}, " +
            "password = #{password}, " +
            "age = #{age}, " +
            "gender = #{gender}, " +
            "math_score = #{mathScore}, " +
            "english_score = #{englishScore}, " +
            "city = #{city} " +
            "WHERE id = #{id}")
    int update(User user);
}