package dao;

import java.util.List;

import entity.Student;;

public interface studentDao {
	public boolean login(String name, String password);

	public boolean insert(Student stu);

	public List<Student> getUserAll();

	public boolean delete(String id);

	public boolean update(String id, String name, String sex, String password, String oid);

}
