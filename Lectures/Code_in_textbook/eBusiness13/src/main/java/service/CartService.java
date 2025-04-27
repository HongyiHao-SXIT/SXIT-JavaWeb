package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import dao.CartDao;
import dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartService {
	CartDao cd = new CartDao();
	IndexService indexService = new IndexService();
	/**
	 * 购物车操作
	 */
	public void opCart(String act, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int bid = ((UserDTO)session.getAttribute("buser")).getId();
		RequestDispatcher rds = null;
		//加入购物车
		if("put".equals(act)) {
			String gno = request.getParameter("goodstable_id");
			String mknum = request.getParameter("shoppingnum");
			cd.putCart(gno, bid, mknum);
			rds = request.getRequestDispatcher("before_cart?act=select");
		}else if("select".equals(act) || "toCount".equals(act)) {//查询购物车或去结算
			indexService.head(request);//head页面信息
			List<Map<String, Object>> listmap = cd.selectCart(bid);
			double total = 0;
			for (Map<String, Object> map : listmap) {
				total = total + ((Double)map.get("smallsum")).doubleValue();
			}
			request.setAttribute("cartlist", listmap);
			request.setAttribute("total", total);
			if("select".equals(act))
				rds = request.getRequestDispatcher("before/cart.jsp");
			else
				rds = request.getRequestDispatcher("before/count.jsp");
		}else if("delete".equals(act)) {//删除购物车
			String gno = request.getParameter("id");
			cd.deleteCart(bid, gno);
			rds = request.getRequestDispatcher("before_cart?act=select");
		}else if("clear".equals(act)) {//清空购物车
			cd.clearCart(bid);
			rds = request.getRequestDispatcher("before_cart?act=select");
		}else if("orderSubmit".equals(act)) {//提交订单
			indexService.head(request);//head页面信息
			String amount = request.getParameter("amount");
			//往订单表插入记录
			int id = cd.addOrder(bid, amount);
			//往订单详情表插入订单详情
			cd.addOrderDetail(id, bid);
			//清空购物车
			cd.clearCart(bid);
			//更新商品库存
			cd.updateGoodsStore(id);
			request.setAttribute("oid", id);
			rds = request.getRequestDispatcher("before/pay.jsp");
		}else if("pay".equals(act)) {//订单支付
			String ordersn = request.getParameter("oid");
			cd.pay(ordersn);
			PrintWriter out = response.getWriter();
			out.println("支付成功！3秒钟返回首页！");
			response.setHeader("refresh", "3; url=before_first?typeid=0");
		}
		rds.forward(request, response);
	}
}
