package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entity.Goods;
@WebServlet("/goodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//将查询结果装到集合ArrayList<Goods>中，并返回页面显示
		ArrayList<Goods> allGoods = null;
		//加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//建立连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8","root","root");
			//预处理
			ps = con.prepareStatement("insert into goods values(null,?,?)");
			//发送添加SQL语句，实现添加的功能
			ps.setString(1, request.getParameter("gname")); 
			ps.setString(2, request.getParameter("gprice"));
			ps.executeUpdate();
			//预处理
			ps = con.prepareStatement("select * from goods ");
			//发送查询SQL语句，返回结果集
			rs = ps.executeQuery();
			//将查询结果装到集合ArrayList<Goods>中
			allGoods = new ArrayList<Goods>();
			while(rs.next()){
				Goods g = new Goods();
				g.setId(rs.getInt(1));
				g.setGname(rs.getString(2));
				g.setGprice(rs.getDouble(3));
				allGoods.add(g);
			}  
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//存到request对象，以便在页面showAllGoods.jsp中显示
		request.setAttribute("allGoods", allGoods);
		//跳转到showAllGoods.jsp显示商品
		RequestDispatcher dis = request.getRequestDispatcher("showAllGoods.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
