package dao;

import java.util.List;
import java.util.Map;

import dto.GoodsDTO;

public class GoodsDao extends BaseDao{
	/**
	 * 添加商品
	 */
	public boolean addGoods(GoodsDTO gdt){
		String sql = "insert into goodstable values(null,?,?,?,?,?,?,?)";
		Object param[] = {
				gdt.getGname(),
				gdt.getGoprice(),
				gdt.getGrprice(),
				gdt.getGstore(),
				gdt.getGpicture(),
				gdt.getGoodstype_id(),
				gdt.getIsshow()
			};
		return upadateByParams(sql, param);
	}
	/**
	 * 修改商品
	 */
	public boolean updateGoods(GoodsDTO gdt){
		String sql = "update goodstable set gname = ?, goprice = ?, grprice = ?, gstore = ?, gpicture = ?, goodstype_id = ?, isshow = ? where id = ?";
		Object param[] = {
				gdt.getGname(),
				gdt.getGoprice(),
				gdt.getGrprice(),
				gdt.getGstore(),
				gdt.getGpicture(),
				gdt.getGoodstype_id(),
				gdt.getIsshow(),
				gdt.getId()
				};
		return upadateByParams(sql, param);
	}
	/**
	 * 查询所有商品
	 */
	public List<Map<String, Object>> selectGoods(){
		String sql = "select * from goodstable gt,goodstype gy where gt.goodstype_id = gy.id ";
		Object param[] = null;
		return select(sql, param);
	}
	/**
	 * 分页查询商品
	 */
	public List<Map<String, Object>> selectAllGoodsByPage(int startIndex, int perPageSize){
		String sql = "select * from goodstable gt,goodstype gy where gt.goodstype_id = gy.id order by gt.id limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}
	/**
	 *  查询一个商品
	 */
	public List<Map<String, Object>> selectAGoods(String id){
		String sql = "select * from goodstable gt,goodstype gy where gt.goodstype_id = gy.id and gt.id = ?";
		Object param[] = {id};
		return select(sql, param);
	}
	/**
	 * 删除商品
	 */
	public boolean deleteAgoods(String gno){
		String sql = "delete  from goodstable where id = ? ";
		Object param[] = {gno};
		return upadateByParams(sql, param);
	}
	/**
	 * 删除商品时，判断有无关联
	 */
	public  boolean isDelete(String gno){
		String sql1 = "select * from goodstable where goodstable_id=?";
		String sql2 = "select * from focustable where goodstable_id=?";
		String sql3 = "select * from orderdetail where goodstable_id=?";
		Object param[] = {gno};
		//有子记录
		if(select(sql1, param).size() > 0 ||
				select(sql2, param).size() > 0 ||
				select(sql3, param).size() > 0){
			return false;
		}else{
			return true;
		}
	}
}
