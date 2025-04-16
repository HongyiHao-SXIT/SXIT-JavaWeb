package servlet;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/IsUseServlet")
public class IsUseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//exitName代表已存在的用户名
	private static ArrayList<String> exitName = new ArrayList<String>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求和响应字符编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String uname = request.getParameter("uname");
		String isResult = "no";
		boolean flag = true;
		for (String string : exitName) {
			if(uname.equals(string)) {
				flag = false;
				break;
			}
		}
		if(flag) {
			isResult = "ok";
			exitName.add(uname);
		}
		//将请求结果数据响应输出
		response.getWriter().print(isResult);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
