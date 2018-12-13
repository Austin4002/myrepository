package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.studentDao;
import dao.studentDaoImp;
import entity.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		List<Student> list = new ArrayList<Student>();
		studentDao stu = new studentDaoImp();
		list = stu.getUserAll();
		if (stu.login(id, password)) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {

			response.sendRedirect("login.html");
		}

	}

}
