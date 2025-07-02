package com.itheima.tlias.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.tlias.bean.Clazz;
import com.itheima.tlias.bean.ClazzQueryParam;
import com.itheima.tlias.bean.PageResult;
import com.itheima.tlias.mapper.ClazzMapper;
import com.itheima.tlias.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService{
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult page(ClazzQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list();
        PageInfo<Clazz> pageInfo = new PageInfo<>(clazzList);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
    
    @Override
    @Transactional
    public void deleteById(Integer id){
        clazzMapper.deleteById(id);
    }

    @Override
    public void AddClass(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.listAll();
    }

    @Override
    public Clazz getById(Integer id) {

        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
}
