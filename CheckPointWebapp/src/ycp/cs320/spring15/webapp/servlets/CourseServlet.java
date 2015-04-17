package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.User;

public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Controller controller = new Controller();
		
		System.out.println("In the course servlet");
		
		String coursePath = req.getPathInfo();
		
		if (coursePath == null || coursePath.equals("/"))
		{
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		else
		{
			coursePath = coursePath.substring(1);
		}
		
		Course currentCourse = controller.findCourseByCourseName(coursePath);
		
		if (currentCourse == null)
		{
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		
		req.setAttribute("courseName", coursePath);
		
		//Calls the index.jsp file containing the html and css
		req.getRequestDispatcher("/_view/course.jsp").forward(req, resp);
	}
}
