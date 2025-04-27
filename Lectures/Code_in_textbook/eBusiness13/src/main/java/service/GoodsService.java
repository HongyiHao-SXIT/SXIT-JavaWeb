package service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import dao.GoodsDao;
import dto.GoodsDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.MyUtil;

public class GoodsService {
	GoodsDao gd = new GoodsDao();
	/**
	 * 查询商品
	 */
	public void selectGoods(String currentPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>>  list = gd.selectGoods();
		//分页查询
		int temp = list.size();
		int totalPage = 0;
		int perPageSize = 5;//每页5个
		if (temp == 0) {
			totalPage = 0;//总页数
		} else {
			//返回大于或者等于指定表达式的最小整数
			totalPage = (int) Math.ceil((double) temp / perPageSize);
		}
		
		if (currentPage == null) {
			currentPage = "1";
		}
		int  pageCur = Integer.parseInt(currentPage);
		if ((pageCur - 1) * perPageSize > temp) {
			pageCur = pageCur - 1;
		}
		//分页查询
		int startIndex = (pageCur - 1) * perPageSize;//起始位置
		list = gd.selectAllGoodsByPage(startIndex, perPageSize);
		request.setAttribute("allGoods", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", pageCur);
		RequestDispatcher rds = request.getRequestDispatcher("admin/selectGoods.jsp");
		rds.forward(request, response);
	}
	/**
	 * 管理商品（修改、详情、删除等链接）
	 */
	public void adminGoods(String id, String act, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list = gd.selectAGoods(id);
		//把一个商品详细信息存到request中
		request.setAttribute("goods", list.get(0));
		RequestDispatcher rds = null;
		PrintWriter out = response.getWriter();
		//详情页面
		if("detail".equals(request.getParameter("act"))){
			rds = request.getRequestDispatcher("admin/goodsDetail.jsp");
		}
		//修改一个商品页面
		else if("updateAgoods".equals(request.getParameter("act"))){
			rds = request.getRequestDispatcher("admin/goodsUpdate.jsp");
		}else {
			if(!gd.isDelete(id)){//有子记录不能删除
				out.println("有子记录，删除失败！2秒钟返回！");
			}else{
				gd.deleteAgoods(id);
				out.println("删除成功！2秒钟返回！");
			}
			response.setHeader("refresh", "2; url=admin_selectGoodsServlet?currentPage=1");
		}
		rds.forward(request, response);
	}
	/**
	 * 新增与修改商品
	 */
	public void addGoods(GoodsDTO gdt, String act, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得Part对象
		jakarta.servlet.http.Part part = request.getPart("gpicture");
		//上传哪里，即文件目录
		//(1)生产环境，服务器上
		//String realpath = request.getServletContext().getRealPath("static/images");
		//(2)开发环境，工作空间
		String realpath = "D:\\idea-workspace\\eBusiness13\\src\\main\\webapp\\static\\images";
		File uploadFileDir = new File(realpath);
		if(!uploadFileDir.exists()){
			uploadFileDir.mkdir();
		}
		//获得原始文件名
		String oldName = part.getSubmittedFileName();
		try{
			String gpicture = null;
			if("add".equals(act)){
				if(oldName != null && oldName.length() > 0){
					//上传时的新文件名
					gpicture = MyUtil.getRandomStr(10) + oldName.substring(oldName.lastIndexOf("."));
					//上传图片
					part.write(uploadFileDir + File.separator + gpicture);
				}
			}else if("update".equals(act)){
				gdt.setId(Integer.parseInt(request.getParameter("id")));
				//修改时没有选择图片，使用旧图片
				System.out.println(oldName + "oldNameoldNameoldNameoldName");
				if(oldName == null || oldName.length() == 0){
					gpicture = request.getParameter("oldgpicture");
				}else{
					//上传时的新文件名
					gpicture = MyUtil.getRandomStr(10) + oldName.substring(oldName.lastIndexOf("."));
					//上传图片
					part.write(uploadFileDir + File.separator + gpicture);
				}
			}
			gdt.setGpicture(gpicture);
		}catch(Exception e){
			e.printStackTrace();
		}
		boolean result = false;
		if("add".equals(act)) {
			result = gd.addGoods(gdt);
		}
		if("update".equals(act)) {
			result = gd.updateGoods(gdt);
		}
		PrintWriter out = response.getWriter();
		if(result) {
			out.println("新增或修改成功！2秒钟返回主界面！");
		}else {
			out.println("新增或修改失败！2秒钟返回主界面！");
		}
		response.setHeader("refresh", "2; url=admin_selectGoodsServlet?currentPage=1");
	}
}
