package com.example.demo.controller;

import com.example.demo.entity.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /**
     * URL（或者表单参数）参数使用形参接收
     * 示例: http://localhost:8080/user/param1?name=zhangsan&age=18
     *

     * @return 固定返回"success"
     */
    @GetMapping("/user/param1")
    public String param1(String name, int age) {
        System.out.println("接收到参数name: " + name);
        System.out.println("接收到参数age: " + age);
        return "success";
    }

    /**
     * URL（或者表单参数）参数使用形参接收
     * http://localhost:8080/user/param2?username=zhangsan&age=18
     *
     * @return
     */
    @GetMapping("/user/param2")
    public String param2(@RequestParam("username") String name, int age) {
        System.out.println("接收到参数name: " + name);
        System.out.println("接收到参数age: " + age);
        return "success";
    }

    /**
     * http://localhost:8080/user/param3?name=lisi&age=22&addr=ny
     * 使用对象接收参数, 对象中的属性名必须和URL中的参数名一致
     *
     * @return
     */
    @GetMapping("/user/param3")
    public String param3(User user) {
        System.out.println("接收到参数 user:" + user);
        return "success";
    }

    /**
     * http://localhost:8080/user/param4?hobby=coding&hobby=game&hobby=rap
     * 使用集合接收参数
     *
     * @param hobby
     * @return
     */
    @GetMapping("/user/param4")
    public String param4(@RequestParam List<String> hobby) {
        System.out.println("接收到集合参数:" + hobby);
        return "success";
    }
    }