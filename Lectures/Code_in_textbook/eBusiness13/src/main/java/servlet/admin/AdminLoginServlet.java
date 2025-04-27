package servlet.admin;
import java.io.IOException;

import dto.AdminDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AdminService;
@WebServlet("/admin_adminLoginServlet_login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//把管理员信息保存到实体模型中
		AdminDTO adt = new AdminDTO();
		adt.setAname(request.getParameter("aname"));
		adt.setApwd(request.getParameter("apwd"));
		//业务层
		AdminService as = new AdminService();
		as.adminLogin(adt, request, response);
	}
}
