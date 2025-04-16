package servlet.admin;

import java.io.IOException;

import dto.GoodsDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GoodsService;

@WebServlet("/admin_addGoods")
@MultipartConfig(maxFileSize = 10*1024*1024)//设置上传文件的最大值为10M
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService gs = new GoodsService();
		GoodsDTO gdt = new GoodsDTO();//实体模型
		//获得动作类型，不是通过表单域提交，所以可以通过request获取
		String act =  request.getParameter("act");
		try{
			String gname = request.getParameter("gname");
			double goprice = Double.parseDouble(request.getParameter("goprice"));
			double grprice = Double.parseDouble(request.getParameter("grprice"));
			int gstore = Integer.parseInt(request.getParameter("gstore"));
			int typeid = Integer.parseInt(request.getParameter("typeid"));
			int isshow = Integer.parseInt(request.getParameter("isshow"));
			gdt.setGname(gname);
			gdt.setGoprice(goprice);
			gdt.setGrprice(grprice);
			gdt.setGoodstype_id(typeid);
			gdt.setGstore(gstore);
			gdt.setIsshow(isshow);
		}catch(Exception e){
			//数据输入有误
			response.sendRedirect("admin/addGoods.jsp");
			return ;
		}
		gs.addGoods(gdt, act, request, response);
	}
}
