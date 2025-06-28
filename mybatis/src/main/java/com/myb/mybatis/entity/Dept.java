package com.myb.mybatis.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 部门表实体类
 */
//@Getter //这个注解是由lombok提供 加在实体类上 会根据实体类的属性生成对应的get方法
//@Setter //这个注解是由lombok提供 加在实体类上 会根据实体类的属性生成对应的set方法
//@ToString //这个注解是由lombok提供 加在实体类上 会根据实体类的属性生成对应的toString方法
//@EqualsAndHashCode //这个注解是由lombok提供 加在实体类上 会根据实体类的属性生成对应的equals和hashCode方法
@Data //这个注解是由lombok提供 加在实体类上 会根据实体类的属性生成对应的getter和setter方法toString equals和hashCode方法 等方法
@NoArgsConstructor //这个注解是由lombok提供 加在实体类上 会根据实体类的属性生成对应的无参构造方法
@AllArgsConstructor //这个注解是由lombok提供 加在实体类上 会根据实体类的属性生成对应有参构造方法
public class Dept {
    /**
     * ID, 主键
     */
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    
}