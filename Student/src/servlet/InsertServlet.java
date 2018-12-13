package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.studentDao;
import dao.studentDaoImp;
import entity.Student;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String password = request.getParameter("password");

		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setPassword(password);
		stu.setSex(sex);

		studentDao stu2 = new studentDaoImp();
		if (stu2.insert(stu)) {
			request.getRequestDispatcher("Search").forward(request, response);
		}else {
			request.getRequestDispatcher("/login.html").forward(request, response);
		}

	}

}
