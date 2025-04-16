package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import dao.UserDao;
import dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserService {
	UserDao userDao = new UserDao();
	/**
	 * 注册
	 */
	public void register(UserDTO udt, String flag, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rds = null;
		if("0".equals(flag)) {//注册按钮
			if(userDao.register(udt)){
					rds = request.getRequestDispatcher("before/login.jsp");
			}else{
					rds = request.getRequestDispatcher("before/register.jsp");
			}
		}else if("1".equals(flag)){//验证邮箱
			//查询E-mail
			List<Map<String, Object>> list = userDao.isExit(udt);
			PrintWriter out = response.getWriter();
			//E-mail已注册
			if(list.size() > 0){
				out.print("<font color=red size=3>该E-mail已注册！</font>");
			}else {
				out.print("<font color=green size=3>该E-mail可注册！</font>");
			}
		}else if("2".equals(flag)){//修改密码
			String id = request.getParameter("id");
			udt.setId(Integer.parseInt(id));
			userDao.updatePWD(udt);
			rds = request.getRequestDispatcher("before/login.jsp");
		}
		rds.forward(request, response);
	}
	/**
	 * 登录
	 */
	public void login(UserDTO udt, String rand, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		//获取验证码
		String code2 = (String)session.getAttribute("rand");
		RequestDispatcher rds = null;
		//验证码输入正确
		if(code2.equalsIgnoreCase(rand)){
			//邮箱输入错误
			if(userDao.isExit(udt).size() < 1 ){
				request.setAttribute("errorMessage", "邮箱输入错误！");
				rds = request.getRequestDispatcher("before/login.jsp");
			}else if(userDao.isLogin(udt).size() < 1){//邮箱正确，密码错误
				request.setAttribute("errorMessage", "密码输入错误！");
				rds = request.getRequestDispatcher("before/login.jsp");
			}else{
				//把bid存到ud中
				udt.setId((Integer)(userDao.isLogin(udt).get(0)).get("id"));
				session.setAttribute("buser", udt);
				//登录成功，转到首页
				rds = request.getRequestDispatcher("before_first?typeid=0");
			}
		}else{
			request.setAttribute("errorMessage", "验证码输入错误！");
			rds = request.getRequestDispatcher("before/login.jsp");
		}
		rds.forward(request, response);
	}
}
