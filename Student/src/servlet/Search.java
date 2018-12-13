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

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Search() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentDao stu = new studentDaoImp();
//		List<Student> stuAll = stu.getUserAll();
		List<Student> list = new ArrayList<Student>();
		list=stu.getUserAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	
	}

}
