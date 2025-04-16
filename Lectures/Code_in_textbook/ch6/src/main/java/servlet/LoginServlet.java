package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "loginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("user"); //获取客户提交的信息
		String password = request.getParameter("pwd");//获取客户提交的信息
		out.println("<html><body>");
		if(name == null || name.length() == 0){
			out.println("请输入用户名");
		}
		else if(password == null || password.length() == 0){
			out.println("请输入密码");
		}
		else if(name.length() > 0 && password.length() > 0){
			if(name.equals("zhangsan") && password.equals("lisi")){
				out.println("信息输入正确");
			}else{
				out.println("信息输入错误");
			}
		}
		out.println("</body></html>");
	} 
}
