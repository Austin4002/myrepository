package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Student;
import conn.DBUtil;

public class studentDaoImp implements studentDao {
	// 增
	public boolean insert(Student stu) {
		boolean flag = false;
		String sql = "insert into student(id,name,sex,password) " + "values(?,?,?,?)";
		Connection conn = DBUtil.init();
		int i = 0;
		try {
			// 执行sql语句
			PreparedStatement prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, stu.getId());
			prestmt.setString(2, stu.getName());
			prestmt.setString(3, stu.getSex());
			prestmt.setString(4, stu.getPassword());
			// i条记录收到影响
			i = prestmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i > 0) {
			flag = true;
		}
		DBUtil.closeConn();
		return flag;
	}

	// 登录检查
	public boolean login(String id, String password) {
		boolean flag = false;
		Connection conn = DBUtil.init();
		try {
			PreparedStatement prestmt = conn.prepareStatement("select * from teacher where id=? and password=?");
			prestmt.setString(1, id);
			prestmt.setString(2, password);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("id").equals(id) && rs.getString("password").equals(password)) {
					flag = true;
				}
			}
			DBUtil.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 查询
	public List<Student> getUserAll() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection conn = DBUtil.init();
			PreparedStatement prestmt = conn.prepareStatement("select * from student");
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getString("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setPassword(rs.getString("password"));
				list.add(stu);
			}
			DBUtil.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 改
	public boolean update(String id, String name, String sex, String password, String oid) {
		boolean flag = false;
		Connection conn = DBUtil.init();
		int i = 0;
		String sql = "update student set id=?, name=?,sex=?,password=? " + " where id =?";
		try {
			PreparedStatement prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, id);
			prestmt.setString(2, name);
			prestmt.setString(3, sex);
			prestmt.setString(4, password);
			prestmt.setString(5, oid);
			i = prestmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i > 0) {
			flag = true;
		}
		DBUtil.closeConn();
		return flag;
	}

	// 删
	public boolean delete(String id) {
		boolean flag = false;
		Connection conn = DBUtil.init();
		String sql = "delete  from student where id=?";
		int i = 0;
		try {
			PreparedStatement prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, id);
			i = prestmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i > 0) {
			flag = true;
		}
		DBUtil.closeConn();
		return flag;
	}
}
