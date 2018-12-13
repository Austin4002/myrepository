package entity;

public class Student {
	String id;
	String name;
	String sex;
	String password;

	public Student(String id, String name, String sex, String password) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.password = password;
	}

	public Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
