package dao;

import java.util.List;
import java.util.Map;

import dto.GoodsTypeDTO;

public class TypeDao extends BaseDao{
	/**
	 * 添加类型
	 */
	public boolean addType(String typename){
		String sql = "insert into goodstype values(null,?)";
		Object param[] = {typename};
		return upadateByParams(sql, param);
	}
	/**
	 * 删除类型
	 */
	public boolean deleteType(String id) {
		String sql = "delete  from goodstype where id = ? ";
		Object param[] = {id};
		return upadateByParams(sql, param);
	}
	/**
	 * 获得商品类型列表
	 */
	public  List<Map<String, Object>> getGoodsType(){
		String sql = "select * from goodstype";
		return select(sql, null);
	}
	/**
	 * 分页查询类型
	 */
	public List<Map<String, Object>> selectAllGoodsTypeByPage(int startIndex, int perPageSize){
		String sql = "select * from goodstype limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}
	/**
	 * 获得关联类型
	 */
	public List<Map<String, Object>> getReType(String id){
		String sql = "select * from goodstable where goodstype_id = ?";
		Object param[] = {id};
		return select(sql, param);
	}
	/**
	 *  查询一个类型
	 */
	public List<Map<String, Object>> selectAGoodsType(String id){
		String sql = "select * from goodstype where id = ?";
		Object param[] = {id};
		return select(sql, param);
	}
	/**
	 * 修改类型
	 */
	public boolean updateGoodsType(GoodsTypeDTO gtd) {
		String sql = "update goodstype set typename = ? where id = ?";
		Object param[] = {gtd.getTypename(), gtd.getId()};	
		return upadateByParams(sql, param);
	}
}
