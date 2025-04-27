package servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/uploadHttpOneServet")
@MultipartConfig(maxFileSize = 10*1024*1024)//设置上传文件的最大值为10M
public class UploadHttpOneServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应的内容类型
		response.setContentType("text/html;charset=utf-8");
		//取得输出对象
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		//获得Part对象
		Part part = request.getPart("resPath");
		String filediscription = request.getParameter("filediscription");
		out.println("输入的文件描述：" + filediscription + "<br>");
		//指定上传的文件保存到服务器的uploadFiles目录中
		File uploadFileDir = new File(getServletContext().getRealPath("/uploadFiles"));
		if(!uploadFileDir.exists()){
			uploadFileDir.mkdir();
		}
		//获得原始文件名
		String oldName = part.getSubmittedFileName();
		out.println("上传文件的原始名：" + oldName + "<br>");
		out.println("上传文件的大小：" + part.getSize() + "<br>");
		if(oldName != null){
			//上传到服务器的uploadFiles目录中
			part.write(uploadFileDir + File.separator + oldName);
		}
		out.println("文件上传到：" + uploadFileDir + File.separator + oldName + "<br>");
	}
}
