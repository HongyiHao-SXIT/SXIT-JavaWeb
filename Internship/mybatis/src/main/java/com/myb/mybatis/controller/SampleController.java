package com.myb.mybatis.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

    @RequestMapping("/")
    public String index(Model model) {
        String resource = "mybatis-config.xml";
        try (Reader in = Resources.getResourceAsReader(resource)) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            SqlSession session = factory.openSession();
            List<Map<String, Object>> result = session.selectList("sample.mybatis.selectTest");
            model.addAttribute("results", result);
        } catch (IOException e) {
        }

        return "index";
    }
}