package dao;
import java.util.List;
import java.util.Map;

import dto.AdminDTO;
public class AdminDao extends BaseDao{
	/**
	 * 管理员登录判定
	 */
	public boolean adminLogin(AdminDTO adt){
		String sql = "select * from ausertable where aname = ? and apwd = ?";
		Object param[] = {adt.getAname(), adt.getApwd()};
		List<Map<String, Object>> list = select(sql, param);
		if(list.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 查询所有订单
	 */
	public List<Map<String, Object>> selectAllOrders(){
		String sql = "select obt.*, bt.bemail from orderbasetable obt, busertable bt "
				+ " where obt.busertable_id = bt.id";
		Object param[] = null;
		return select(sql, param);
	}
	/**
	 * 分页查询订单
	 */
	public List<Map<String, Object>> selectAllOrdersByPage(int startIndex, int perPageSize){
		String sql = "select obt.*, bt.bemail from orderbasetable obt, busertable bt "
				+ " where obt.busertable_id = bt.id limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}
	/**
	 * 按月统计（最近1年的）
	 */
	public List<Map<String, Object>> selectOrderByMonth(){
		String sql = " select sum(amount) totalamount, date_format(orderdate,'%Y-%m') months "
				+ "	  from orderbasetable  where status = 1 and orderdate > date_sub(curdate(), interval 1 year) "
				+ "	 group by months order by months ";
		return select(sql, null);
	}
	/**
	 * 按类型统计（最近1年的）
	 */
	public List<Map<String, Object>> selectOrderByType(){
		String sql = " select sum(gt.grprice * od.shoppingnum) value, gdy.typename "
				+ " from orderbasetable ob, orderdetail od, goodstype gdy, goodstable gt "
				+ " where ob.status = 1 and ob.orderdate > date_sub(curdate(), interval 1 year) and "
				+ " od.orderbasetable_id=ob.id and gt.id=od.goodstable_id and "
				+ " gt.goodstype_id = gdy.id group by gdy.typename ";
		return select(sql, null);
	}
}
