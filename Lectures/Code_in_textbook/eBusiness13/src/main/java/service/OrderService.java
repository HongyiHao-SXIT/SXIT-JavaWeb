package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.AdminDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderService {
	public void adminOrder(String act, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao ad = new AdminDao();
		if("selectOrder".equals(act)) {
			String currentPage = request.getParameter("currentPage");
			List<Map<String, Object>>  list = ad.selectAllOrders();
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
			list = ad.selectAllOrdersByPage(startIndex, perPageSize);
			request.setAttribute("allOders", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", pageCur);
			RequestDispatcher rds = request.getRequestDispatcher("admin/orderManage.jsp");
			rds.forward(request, response);
		}else if("selectOrderByMonth".equals(act)) {//按月统计（最近1年的）
			List<Map<String, Object>>  myList = ad.selectOrderByMonth();
			List<String> months = new ArrayList<String>();
			List<Double> totalAmount = new ArrayList<Double>();
			for (Map<String, Object> map : myList) {
				months.add("'" + map.get("months") + "'");
				totalAmount.add((Double)map.get("totalamount"));
			}
			request.setAttribute("months", months);
			request.setAttribute("totalAmount", totalAmount);
			RequestDispatcher rds = request.getRequestDispatcher("admin/selectOrderByMonth.jsp");
			rds.forward(request, response);
		}else if("selectOrderByType".equals(act)) {//按类型统计（最近1年的）
			List<Map<String, Object>>  myList = ad.selectOrderByType();
			List<String> typenames = new ArrayList<String>();
			List<Double> totalAmount = new ArrayList<Double>();
			for (Map<String, Object> map : myList) {
				typenames.add("'" + (String)map.get("typename") + "'");
				totalAmount.add((Double)map.get("value"));
			}
			request.setAttribute("typenames", typenames);
			request.setAttribute("totalAmount", totalAmount);
			RequestDispatcher rds = request.getRequestDispatcher("admin/selectOrderByType.jsp");
			rds.forward(request, response);
		}
	}
}
