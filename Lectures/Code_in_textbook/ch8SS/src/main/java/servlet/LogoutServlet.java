package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        this.doPost(request, response);  
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");         
	   String username = request.getParameter("id");//即将注销的当前用户 
        //从应用上下文中获取在线用户名列表  
        @SuppressWarnings("unchecked")
		List<String> online = (List<String>)getServletContext().getAttribute("online"); 
        online.remove(username);
        //销毁会话
        request.getSession().invalidate(); 
        response.setContentType("text/html;charset=utf-8");  
        PrintWriter out = response.getWriter();  
        out.println("");  
        out.println("  <title>用户列表</title>");  
        out.println("  ");  
        out.print("    <h3>在线用户列表</h3>");  
        int size = online == null ? 0 : online.size();  
        for (int i = 0; i < size; i++) {  
            if(i > 0){  
                out.println("<br>");  
            }  
            out.println(i + 1 + "." + online.get(i));  
        }    
        out.println("<hr><a href=\"index.jsp\"'>主页</a>");  
        out.println("  ");  
        out.println("");  
        out.flush();  
        out.close();  
    }  
}
