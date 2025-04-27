package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import dao.TypeDao;
import dto.GoodsTypeDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TypeService {
	public void adminType(String act, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypeDao td = new TypeDao();
		if("add".equals(act)) {
			String typename = request.getParameter("typename");
			td.addType(typename);
			//获得商品类型
			List<Map<String, Object>>  list = td.getGoodsType();
			HttpSession session = request.getSession(true);
			session.setAttribute("goodsType", list);
			response.sendRedirect("admin_Type?act=select&currentPage=1");
		}else if("select".equals(act)) {
			String currentPage = request.getParameter("currentPage");
			List<Map<String, Object>> allType = td.getGoodsType();
			//分页查询
			int temp = allType.size();
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
			allType = td.selectAllGoodsTypeByPage(startIndex, perPageSize);
			request.setAttribute("allType", allType);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", pageCur);
			RequestDispatcher rds = request.getRequestDispatcher("admin/selectType.jsp");
			rds.forward(request, response);
		}else if("delete".equals(act)) {
			String id = request.getParameter("id");
			PrintWriter out = response.getWriter();
			if(td.getReType(id).size() > 0) {
				out.println("有子记录，无法删除！3秒钟返回");
			}else {
				td.deleteType(id);
				out.println("删除成功！3秒钟返回");
			}
			//获得商品类型
			List<Map<String, Object>>  list = td.getGoodsType();
			HttpSession session = request.getSession(true);
			session.setAttribute("goodsType", list);
			response.setHeader("refresh", "3; url=admin_Type?act=select&currentPage=1");
		}else if("updateSelect".equals(act)) {
			String id = request.getParameter("id");
			List<Map<String, Object>>  list = td.selectAGoodsType(id);
			request.setAttribute("goodsType", list.get(0));
			RequestDispatcher rds = request.getRequestDispatcher("admin/updateType.jsp");
			rds.forward(request, response);
		}else if("update".equals(act)) {
			String id = request.getParameter("id");
			String typename = request.getParameter("typename");
			GoodsTypeDTO gtd = new GoodsTypeDTO();
			gtd.setId(Integer.parseInt(id));
			gtd.setTypename(typename);
			td.updateGoodsType(gtd);
			PrintWriter out = response.getWriter();
			out.println("修改成功！3秒钟返回");
			//获得商品类型
			List<Map<String, Object>>  list = td.getGoodsType();
			HttpSession session = request.getSession(true);
			session.setAttribute("goodsType", list);
			response.setHeader("refresh", "3; url=admin_Type?act=select&currentPage=1");
		}
	}
}
