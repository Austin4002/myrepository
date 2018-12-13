package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	static String username = "root";
	static String password = "123456";
	static Connection conn = null;

	//初始化数据库，连接
	public static Connection init() {
		try {
			//加载MYSQL JDBC驱动程序
			Class.forName("com.mysql.cj.jdbc.Driver");
			//
			//获得连接对象
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("init [SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
		return conn;
	}

	
	//关闭数据库
	public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql数据库关闭异常");
			e.printStackTrace();
		}
	}
}
