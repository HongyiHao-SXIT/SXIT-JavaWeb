package dao;

import java.util.List;
import java.util.Map;

public class IndexDao extends BaseDao{
	/**
	 * 获得最新商品  
	 */
	public List<Map<String, Object>>  getLastedGoods(String typeid){
		//首页
		if("0".equals(typeid)){
			String sql = "select * from goodstable gt, goodstype gy where gt.goodstype_id = gy.id and gt.isshow = 0 "
					+ "   order by  gt.id desc ";
			return select(sql, null);
		}else{
			String  sql = "select * from goodstable gt, goodstype gy where gt.goodstype_id = gy.id "
					+ " and gt.isshow = 0 and gt.goodstype_id = ?  order by  gt.id desc ";
			Object param[] = {typeid};
			return select(sql, param);
		}
	}
	/**
	 * 获得广告商品
	 */
	public List<Map<String, Object>> selectAdviseGoods(){
		String sql = " select * from goodstable where isshow = 1 order by id desc ";
		return select(sql, null);
	} 
	/**
	 * 首页搜索
	 */
	public List<Map<String, Object>> search(String mykey){
		String sql = "select * from  goodstable where isshow = 0 "
				+ "	 and gname like concat('%', ? , '%') "
				+ "	order by id desc ";
		Object param[] = {mykey};
		return select(sql, param);
	}
	
	/**
	 * 关注商品
	 */
	public boolean focusGoods(String gno, int bid){
		String sql = "insert into FOCUSTABLE values(null,?,?,now())";
		Object param[] = {gno, bid};
		return upadateByParams(sql, param);
	}
	/**
	 * 查看是否已关注
	 */
	public List<Map<String, Object>> isFocus(String gno, int bid){
		String sql = "select * from FOCUSTABLE where goodstable_id = ? and busertable_id = ? ";
		Object param[] = {gno, bid};
		return select(sql, param);
	}
	/**
	 * 我的关注
	 */
	public List<Map<String, Object>> myFocus(int bid){
		String sql = " select gt.id, gt.gname, gt.goprice, gt.grprice, gt.gpicture from FOCUSTABLE ft, GOODSTABLE gt " +
				" where ft.goodstable_id=gt.id and  ft.busertable_id = ? ";
		Object param[] = {bid};
		return select(sql, param);
	}
	/**
	 * 我的订单
	 */
	public List<Map<String, Object>> myOrder(int bid){
		String sql = " select id, amount, busertable_id, status, orderdate  from ORDERBASETABLE where busertable_id = ? ";
		Object param[] = {bid};
		return select(sql, param);
	}
	/**
	 * 我的订单详情
	 */
	public List<Map<String, Object>> myOrderDetail(String ordersn){
		String sql =" select gt.id, gt.gname, gt.goprice, gt.grprice, gt.gpicture, odt.shoppingnum from  GOODSTABLE gt, ORDERDETAIL odt " +
				" where  odt.orderbasetable_id = ? and gt.id=odt.goodstable_id ";
		Object param[] = {ordersn};
		return select(sql, param);
	}
}
