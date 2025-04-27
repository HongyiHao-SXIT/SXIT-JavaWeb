package dao;

import java.util.List;
import java.util.Map;

import dto.UserDTO;

public class UserDao extends BaseDao{
	/**
	 * 注册
	 */
	public boolean register(UserDTO ud){
		String sql = "insert into BUSERTABLE values(null,?,?) ";
		Object param[] = {ud.getBemail(), ud.getBpwd()};
		return upadateByParams(sql, param);
	}
	/**
	 * 查询Email
	 */
	public List<Map<String, Object>> isExit(UserDTO ud){
		String sql = "select * from BUSERTABLE where BEMAIL = ? ";
		Object param[] = {ud.getBemail()};
		return select(sql, param);
	}
	/**
	 * 登录判定
	 */
	public List<Map<String, Object>> isLogin(UserDTO ud){
		String sql = "select * from BUSERTABLE where BEMAIL = ? and BPWD = ? ";
		Object param[] = {ud.getBemail(), ud.getBpwd()};
		return select(sql, param);
	} 
	/**
	 * 修改密码
	 */
	public boolean updatePWD(UserDTO ud){
		String sql = "update BUSERTABLE set BPWD = ? where id = ?";
		Object param[] = {ud.getBpwd(), ud.getId()};
		return upadateByParams(sql, param);
	}
}
