package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import java.time.LocalDate;
import java.util.List;

public interface ClazzService {



    PageResult page(Integer page, Integer pageSize,String name, LocalDate begin, LocalDate end);

    void deleteById(Integer id);

    void save(Clazz clazz);

    Clazz getById(Integer id);

    void updateById(Clazz clazz);

    List<Clazz> list();
}
