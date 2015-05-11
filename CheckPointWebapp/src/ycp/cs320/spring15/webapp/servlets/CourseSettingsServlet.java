package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.User;

public class CourseSettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Controller controller = new Controller();
		
		System.out.println("In the course settings servlet");
		
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
		
		 if(!controller.isUserTeacher((String)req.getSession().getAttribute("username"), coursePath))
		 {
			 resp.sendRedirect(req.getContextPath() + "/index");
		 }
		
		req.setAttribute("courseName", coursePath);
		
		req.getSession().setAttribute("courseName", coursePath);
		
		
		//Calls the index.jsp file containing the html and css
		req.getRequestDispatcher("/_view/courseSettings.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Controller controller = new Controller();
	
		System.out.println("doPost called");
		
		if(req.getParameter("AS") != null)
		{
			String newStudent = req.getParameter("StudentName");
			System.out.print("Trying to add " + newStudent + " as a student.");
			int r = controller.addStudentToCourse((String)req.getSession().getAttribute("courseName"), newStudent);
			if(r == 1)
			{
				System.out.println("Success!");
			}
			else
			{
				System.out.println("Failure: " + r);
			}
		}
		
		req.getRequestDispatcher("/_view/courseSettings.jsp").forward(req, resp);
	}
	
}
	
