package servlet.before;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.IndexService;

@WebServlet(name = "before_detail", urlPatterns = { "/before_detail" })
public class BeforeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得商品编号
		String gno = request.getParameter("gno");
		IndexService indexService = new IndexService();
		indexService.detail(request, response, gno);
	}
}
