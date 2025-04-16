package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String username = request.getParameter("username"); // 获取请求参数中的用户名
		// 往session中添加属性,会触发HttpSessionAttributeListener中的attributeAdded方法
		if (username != null && !username.equals("")) {
			request.getSession().setAttribute(username, username);
		}
		// 从应用上下文中获取在线用户名列表
		@SuppressWarnings("unchecked")
		List<String> online = (List<String>) getServletContext().getAttribute("online");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("");
		out.println("  <title>用户列表</title>");
		out.println("  ");
		out.println("当前用户是：" + username);
		out.print("    <hr><h3>在线用户列表</h3>");
		int size = online == null ? 0 : online.size();
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				out.println("<br>");
			}
			out.println(i + 1 + "." + online.get(i));
		}
		// 注意: 要对链接URL进行自动重写处理
		out.println("<hr/><a href=\"" + response.encodeURL("logoutServlet?id=" + username) + "\">注销</a>");
		out.println("  ");
		out.println("");
		out.flush();
		out.close();
	}
}
