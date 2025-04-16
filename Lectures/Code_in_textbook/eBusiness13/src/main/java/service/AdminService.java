package service;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import dao.AdminDao;
import dao.TypeDao;
import dto.AdminDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class AdminService {
	AdminDao ad = new AdminDao();
	TypeDao td = new TypeDao();
	/**
	 * 管理员登录判定
	 */
	public void adminLogin(AdminDTO adt, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//登录成功
		if(ad.adminLogin(adt)){
			//把登录存储到session中
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", adt);
			//获得商品类型
			List<Map<String, Object>>  list = td.getGoodsType();
			session.setAttribute("goodsType", list);
			//跳转到查询商品
			RequestDispatcher rds = request.getRequestDispatcher("admin_selectGoodsServlet?currentPage=1");
			rds.forward(request, response);
		}else{//登录失败
			request.setAttribute("errorMessage", "用户名或密码错误！");
			response.sendRedirect("admin/login.jsp");
		}
	}
}
