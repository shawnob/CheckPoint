package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.spring15.model.User;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the Index servlet");
		
		ArrayList <String> cTList;
		ArrayList <String> cSList;
		Controller controller = new Controller();
		
		
		if (req.getSession().getAttribute("user") instanceof User && req.getSession().getAttribute("user") != null)
		{
			User user = (User)(req.getSession().getAttribute("user"));
			String uname = (String)(req.getSession().getAttribute("username"));
			req.setAttribute("useyName", uname);
			System.out.println(uname + " has logged in");
			
			cTList = controller.getTeacherCourseListByUsername(uname);
			cSList = controller.getStudentCourseListByUsername(uname);
			
			req.setAttribute("TCourses", cTList);
			req.setAttribute("SCourses", cSList);
		}
		else
		{
			req.setAttribute("useyName", "User");
		}
		
		//Calls the index.jsp file containing the html and css
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
}
