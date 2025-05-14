import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 设置响应内容类型和编码
        response.setContentType("text/html;charset=UTF-8");
        
        // 获取用户名参数
        String username = request.getParameter("username");
        
        if (username == null || username.trim().isEmpty()) {
            request.setAttribute("message", "用户名不能为空");
        } else {
            // 获取或创建Session
            HttpSession session = request.getSession();
            
            // 将用户名存入Session
            session.setAttribute("username", username);
            
            // 输出到服务器控制台
            System.out.println("用户名已存入Session: " + username);
            
            // 设置成功消息
            request.setAttribute("message", "用户名 '" + username + "' 已成功存入Session");
        }
        
        // 转发回JSP页面
        request.getRequestDispatcher("sessionForm.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 直接显示表单页面
        request.getRequestDispatcher("sessionForm.jsp").forward(request, response);
    }
}