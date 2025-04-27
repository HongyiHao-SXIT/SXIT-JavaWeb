package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//建议urlPatterns的值和类名一样，方便维护。可使用@WebServlet("/secondServlet")简化注解。
@WebServlet(name = "secondServlet", urlPatterns = { "/secondServlet" }) 
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应的内容类型
		response.setContentType("text/html;charset=utf-8");
		//取得输出对象
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		//在浏览器中显示：第二个Servlet类
		out.println("第二个Servlet类");
		out.println("</body></html>");
	}
}
