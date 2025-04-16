package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CartDao extends BaseDao{
	/**
	 *  放入购物车
	 */
	public boolean putCart(String gno, int bid, String mknum){
		String sql1 = "select * from carttable where busertable_id=? and goodstable_id=? ";
		Object param1[] = {bid, gno};
		String sql2 = "update carttable set shoppingnum=shoppingnum+? where  busertable_id=? and goodstable_id=?";
		Object param2[] = {mknum, bid, gno};
		String sql3 = "insert into carttable values(null,?,?,?)";
		Object param3[] = {bid, gno, mknum};
		//购物车中已存在
		if(select(sql1, param1).size() > 0){
			return upadateByParams(sql2, param2);
		}else{//购物车中不存在
			return upadateByParams(sql3, param3);
		}
	}
	/**
	 * 查询购物车
	 */
	public List<Map<String, Object>> selectCart(int bid){
		String sql = " select gt.id, gt.gname, gt.gpicture, gt.grprice, ct.shoppingnum, ct.shoppingnum*gt.grprice smallsum " +
				" from GOODSTABLE gt, CARTTABLE ct where gt.id=ct.goodstable_id and ct.busertable_id=? ";
		Object param[] = {bid};
		return select(sql, param);
	}
	/**
	 * 删除购物车
	 */
	public boolean deleteCart(int bid, String gno){
		String sql = "delete from CARTTABLE where busertable_id=? and goodstable_id=? ";
		Object param[] = {bid, gno};
		return upadateByParams(sql, param);
	}
	/**
	 * 清空购物车
	 */
	public boolean clearCart(int bid){
		String sql = "delete from CARTTABLE where busertable_id=? ";
		Object param[] = {bid};
		return upadateByParams(sql, param);
	}
	/**
	 * 往订单表插入记录
	 */
	public int addOrder(int bid, String amount){
		String sql = "insert into ORDERBASETABLE values(null,?,?,?,now())";
		Object param[] = {bid, amount, "0"};//0代表没有支付
		String sql1 = " select LAST_INSERT_ID() from ORDERBASETABLE ";
		return getLastId(sql, sql1, param);
	}
	/**
	 * 往订单表详情插入记录
	 */
	public boolean addOrderDetail(int ordersn,int bid){
		String sql = "insert into ORDERDETAIL (orderbasetable_id, goodstable_id, SHOPPINGNUM) select " + ordersn + ", goodstable_id, SHOPPINGNUM from CARTTABLE where busertable_id = ?  ";
		Object param[] = {bid};
		return upadateByParams(sql, param);
	}
	/**
	 * 更新商品库存
	 */
	public boolean updateGoodsStore(int ordersn){
		boolean b=false;
		Connection con = getConnection();
		PreparedStatement ps=null;
		Connection con1=getConnection();
		PreparedStatement ps1=null;
		ResultSet rs=null;
		try {
			ps1=con1.prepareStatement("select shoppingnum, goodstable_id from orderdetail where orderbasetable_id=?");
			ps1.setInt(1, ordersn);
			rs=ps1.executeQuery();
			ps=con.prepareStatement("update GOODSTABLE set GSTORE=GSTORE-? where id=? ");
			//批量更新
			while(rs.next()){
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, rs.getString(2));
				ps.addBatch();
			}
			int n[]=ps.executeBatch();
			if(n[0]>0)
				b=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs,ps1,con1);
			close(null,ps,con);
		}
		return b;
	}
	/**
	 * 订单支付
	 */
	public boolean pay(String ordersn){
		String sql = "update ORDERBASETABLE set STATUS=1 where id = ?";
		Object param[] = {ordersn};
		return upadateByParams(sql, param);
	}
}
