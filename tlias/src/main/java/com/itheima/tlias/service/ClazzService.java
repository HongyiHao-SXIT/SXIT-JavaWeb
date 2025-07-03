package com.itheima.tlias.service;

import com.itheima.tlias.bean.Clazz;
import com.itheima.tlias.bean.ClazzQueryParam;
import com.itheima.tlias.bean.PageResult;
import java.util.List;

public interface ClazzService {
    
    PageResult page(ClazzQueryParam queryParam);
    void deleteById(Integer id);
    void AddClass(Clazz clazz);
    Clazz getById(Integer id);
    void update(Clazz clazz);
    List<Clazz> list();
}