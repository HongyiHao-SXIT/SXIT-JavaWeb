package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws IOException{
		//设置响应的内容类型
		response.setContentType("text/html;charset=utf-8");
		//取得输出对象
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		//在浏览器中显示：第一个Servlet类
		out.println("第一个Servlet类");
		out.println("</body></html>");
	} 
}
