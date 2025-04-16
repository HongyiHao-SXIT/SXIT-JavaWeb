package servlet;
import java.io.File;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/showDownServlet")
public class ShowDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//指定从服务器的uploadFiles目录中，下载文件
		File downLoadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		//获得目录中的文件
		File[] list = downLoadFileDir.listFiles();
		request.setAttribute("fileList", list);
		RequestDispatcher dis = request.getRequestDispatcher("showInfo.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
