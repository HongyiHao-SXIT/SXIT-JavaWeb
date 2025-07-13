package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public PageResult page(Integer page, Integer pageSize,String name, LocalDate begin, LocalDate end){
        PageHelper.startPage(page, pageSize);
        List<Clazz> clazzList = clazzMapper.list(name, begin, end); // ✅ 正确调用
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }
    @Override
    public void save(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());

        clazzMapper.save(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void updateById(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    @Override
    public List<Clazz> list() {
      return clazzMapper.lists();
    }
}
