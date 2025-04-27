package servlet;

import java.io.IOException;
  
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "redirectForwardServlet", urlPatterns = { "/redirectForwardServlet" })
public class RedirectForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user");
		String password = request.getParameter("pwd");
		if (name == null || name.length() == 0) {
			// 使用response调用sendRedirect方法重定向到redirectForward.jsp
			response.sendRedirect("redirectForward.jsp");
		} else if (password == null || password.length() == 0) {
			response.sendRedirect("redirectForward.jsp");
		} else if (name.length() > 0 && password.length() > 0) {
			// 转发
			RequestDispatcher dis = request.getRequestDispatcher("showServlet");
			dis.forward(request, response);
		}

	}

}
