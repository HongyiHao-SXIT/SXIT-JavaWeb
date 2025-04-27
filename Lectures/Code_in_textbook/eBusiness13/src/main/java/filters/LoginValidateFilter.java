package filters;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginValidateFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("UTF-8");
		// 得到用户请求的URI
		String request_uri = req.getRequestURI();
		// 得到web应用程序的上下文路径
		String ctxPath = req.getContextPath();
		// 去除上下文路径，得到剩余部分的路径
		String uri = request_uri.substring(ctxPath.length());
		boolean adminflag = false;
		boolean beforeflag = false;
		// 默认主页或css文件、图片文件、JS
		if ("/".equals(uri) || uri.contains("static")) {
			chain.doFilter(request, response);
		}
		// JSP请求
		if (uri.contains(".jsp")) {
			// admin文件夹
			if (uri.contains("admin/")) {
				if (uri.contains("login.jsp") || null != session.getAttribute("admin")) {
					chain.doFilter(request, response);
				} else {
					adminflag = true;
				}
			}
			// before文件夹
			else if (uri.contains("before/")) {
				if (null != session.getAttribute("buser") || uri.contains("register.jsp") || // 注册页面
						uri.contains("login.jsp") || // 登录
						uri.contains("head.jsp") || // 登录
						uri.contains("index.jsp") ||
						uri.contains("goodsDetail.jsp")
				) {
					chain.doFilter(request, response);
				} else {
					beforeflag = true;
				}
			}
			// 除admin和beforeUser以外的JSP
			else {
				chain.doFilter(request, response);
			}
		} // JSP请求结束
			// servlet请求
		else {
			// 后台管理的servlet请求
			if (uri.contains("admin_")) {
				if (uri.contains("_login") || null != session.getAttribute("admin")) {
					chain.doFilter(request, response);
				} else {
					adminflag = true;
				}
			}
			// 前台的servlet请求
			else if (uri.contains("before_")) {
				if (null != session.getAttribute("buser") || uri.contains("_first") || // 首页
						uri.contains("_detail") || // 商品详情
						uri.contains("_userLogin") || // 登录
						uri.contains("_search") || // 头部搜索
						uri.contains("_register") || // 注册
						uri.contains("_validateCode")// 验证码
				) {
					chain.doFilter(request, response);
				} else {
					beforeflag = true;
				}
			}
		} // servlet请求结束
		String before_uri = request_uri.substring(0, ctxPath.length());
		String pah = "login.jsp";
		if (beforeflag) {// 前台没有登录
			PrintWriter out = resp.getWriter();
			out.println("您没有登录，请先<a href=" + before_uri + "/before/" + pah + " target=_top>登录</a>！");
			return;
		}
		if (adminflag) {// 后台没有登录
			PrintWriter out = resp.getWriter();
			out.println("您没有登录，请先<a href=" + before_uri +"/admin/" + pah + " target=_top>登录</a>！");
			return;
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
