package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	static String username = "root";
	static String password = "123456";
	static Connection conn = null;

	//��ʼ�����ݿ⣬����
	public static Connection init() {
		try {
			//����MYSQL JDBC��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//
			//������Ӷ���
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("init [SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
		return conn;
	}

	
	//�ر����ݿ�
	public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
}
