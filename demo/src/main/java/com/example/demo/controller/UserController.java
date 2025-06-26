package com.example.demo.controller;

import com.example.demo.entity.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")//请求映射  可以定义在类上，也可以定义在方法上 可以接收任意类型的请求. 如果定义在类上，这个路径就是当前类中所有方法路径的前缀
public class UserController {

    /**
     * URL（或者表单参数）参数使用形参接收
     * http://localhost:8080/user/param1?name=zhangsan&age=18
     *
     * @return
     */
    @GetMapping("/param1") //请求映射 跟@ReuqestMapping类似，区别在于请求方式不同， @GetMapping只能接收GET请求
    public String param1(String name, int age) {
        System.out.println("接收到参数name:" + name);
        System.out.println("接收到参数age:" + age);
        return "success";
    }


    /**
     * URL（或者表单参数）参数使用形参接收
     * http://localhost:8080/user/param2?username=zhangsan&age=18
     *
     * @return
     */
    @GetMapping("/param2")
    public String param2(@RequestParam("username") String name, int age) {
        System.out.println("接收到参数name:" + name);
        System.out.println("接收到参数age:" + age);
        return "success";
    }

    /**
     * http://localhost:8080/user/param3?name=lisi&age=22&addr=ny
     * 使用对象接收参数, 对象中的属性名必须和URL中的参数名一致
     *
     * @return
     */
    @GetMapping("/param3")
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
    @GetMapping("/param4")
    public String param4(@RequestParam List<String> hobby) {
        System.out.println("接收到集合参数:" + hobby);
        return "success";
    }

    /**
     * http://localhost:8080/user/param5?birthday=2019-10-09 10:10:10
     * 使用java中的日期对象来接收 Date
     *
     * @param birthday
     * @return
     */
    @GetMapping("/param5")
    public String param5(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date birthday) {
        System.out.println("接收到日期参数:" + birthday);
        return "success  " + birthday;
    }

    /**
     * POST http://localhost:8080/user/param6
     * Body:
     * {
     * "name":"zhangsan",
     * "age":18,
     * "addr":"南阳师范"
     * }
     * 控制层只能使用对象来接收
     *
     * @return
     */
    @PostMapping("/param6")
    public String param6(@RequestBody User user) {
        System.out.println("接收到json参数:" + user);
        return "success";
    }

    /**
     * GET http://localhost:8080/user/param7/101/Hongyi_Hao
     * 使用形参接收
     *
     * @param id
     * @return
     */
    @GetMapping("/param7/{id}/{name}")
    public String param7(@PathVariable("id") int id, @PathVariable("name") String name) {
        System.out.println("接收到路径参数:" + id + name);
        return "success";
    }

    @GetMapping("/resp1")
    public List<User> resp2() {
        User user1 = new User();
        user1.setName("Lnayi");
        user1.setAge(20);
        user1.setAddr("Shanxi");
        User user2 = new User();
        user2.setName("Joyang");
        user2.setAge(19);
        user2.setAddr("GuiZhou");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;
    }
    
}