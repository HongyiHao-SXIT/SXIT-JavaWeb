package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import dao.GoodsDao;
import dao.IndexDao;
import dao.TypeDao;
import dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class IndexService {
	IndexDao  indexDao = new IndexDao();
	TypeDao typeDao = new TypeDao();
	/**
	 * 导航页信息
	 */
	public void head(HttpServletRequest request) {
		//广告商品
		request.setAttribute("adviseGoods", indexDao.selectAdviseGoods());
		//类型
		request.setAttribute("allTypes", typeDao.getGoodsType());
	}   
	/**
	 * 首页信息
	 */
	public void index(HttpServletRequest request, HttpServletResponse response, String typeid) throws ServletException, IOException  {
		head(request);
		request.setAttribute("lastedGoods", indexDao.getLastedGoods(typeid));
		RequestDispatcher rds = request.getRequestDispatcher("before/index.jsp");
		rds.forward(request, response);
	}
	/**
	 * 首页搜索
	 */
	public void search(HttpServletRequest request, HttpServletResponse response, String mykey) throws ServletException, IOException  {
		head(request);
		request.setAttribute("lastedGoods", indexDao.search(mykey));
		RequestDispatcher rds = request.getRequestDispatcher("before/index.jsp");
		rds.forward(request, response);
	}
	/**
	 * 商品详情
	 */
	public void detail(HttpServletRequest request, HttpServletResponse response, String gno) throws ServletException, IOException  {
		head(request);
		GoodsDao gd = new GoodsDao();
		List<Map<String, Object>> list = gd.selectAGoods(gno);
		//把一个商品详细信息存到request中
		request.setAttribute("goods", list.get(0));
		RequestDispatcher rds =request.getRequestDispatcher("before/goodsDetail.jsp");
		rds.forward(request, response);
	}
	/**
	 * 关注商品
	 */
	public void focusGoods(String gno, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(true);
		int bid = ((UserDTO)session.getAttribute("buser")).getId();
		PrintWriter out = response.getWriter();
		//已关注
		if(indexDao.isFocus(gno, bid).size() > 0){
			out.print("该商品已收藏！");
		}else{//未关注
			if(indexDao.focusGoods(gno, bid)){
				out.print("成功收藏该商品！");
			}else{
				out.print("收藏失败！");
			}
		}
	}
	/**
	 * 我的收藏、订单及购物车
	 */
	public void my(String act, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		head(request);
		HttpSession session = request.getSession(true);
		int bid = ((UserDTO)session.getAttribute("buser")).getId();
		if("myFocus".equals(act)){
			//我的关注
			List<Map<String, Object>> myFocus = indexDao.myFocus(bid);
			request.setAttribute("myFocus", myFocus);
			request.getRequestDispatcher("before/myFocus.jsp").forward(request, response);
		}else if("myOrder".equals(act)){
			//我的订单
			List<Map<String, Object>> myOrder = indexDao.myOrder(bid);
			request.setAttribute("myOrder", myOrder);
			request.getRequestDispatcher("before/myOrder.jsp").forward(request, response);
		}else if("orderDetail".equals(act)) {
			//订单详情
			List<Map<String, Object>> orderDetail = indexDao.myOrderDetail(request.getParameter("id"));
			request.setAttribute("orderDetail", orderDetail);
			request.getRequestDispatcher("before/orderDetail.jsp").forward(request, response);
		}
	}
}
