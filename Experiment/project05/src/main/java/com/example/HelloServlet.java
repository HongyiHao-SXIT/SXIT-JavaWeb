package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// 使用注解方式映射 Servlet 路径
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    // 初始化方法，在 Servlet 实例创建时调用
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("HelloServlet 初始化");
    }

    // 处理 GET 请求
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        // 获取输出流
        PrintWriter out = response.getWriter();
        try {
            // 输出 HTML 内容
            out.println("<html>");
            out.println("<head><title>Hello Servlet</title></head>");
            out.println("<body>");
            out.println("<h1>Hello, Servlet!</h1>");
            // 使用 request 对象获取请求参数
            String name = request.getParameter("name");
            if (name != null && !name.isEmpty()) {
                out.println("<p>你好, " + name + "!</p>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // 处理 POST 请求
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通常将 POST 请求转发给 doGet 方法处理
        doGet(request, response);
    }

    // 销毁方法，在 Servlet 实例销毁时调用
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("HelloServlet 销毁");
    }
}