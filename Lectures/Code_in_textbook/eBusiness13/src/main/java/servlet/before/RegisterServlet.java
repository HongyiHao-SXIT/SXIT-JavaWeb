package servlet.before;
import java.io.IOException;

import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import util.MD5Util;

@WebServlet("/before_register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bemail = request.getParameter("bemail");
		String bpwd = request.getParameter("bpwd");
		String flag = request.getParameter("flag");
		//实体
		UserDTO ud = new UserDTO();
		ud.setBemail(bemail);
		//将明文变为密文
		ud.setBpwd(MD5Util.MD5(bpwd));
		//业务
		UserService us = new UserService();
		us.register(ud, flag, request, response);
	}
}
