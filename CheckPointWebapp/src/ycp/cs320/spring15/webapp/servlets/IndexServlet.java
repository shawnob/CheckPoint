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
		
		ArrayList <String> cList = new ArrayList <String>();
		
		
		if (req.getSession().getAttribute("user") instanceof User && req.getSession().getAttribute("user") != null)
		{
			User usey = (User)(req.getSession().getAttribute("user"));
			String uname = (String)(req.getSession().getAttribute("username"));
			req.setAttribute("useyName", uname);
			System.out.println(uname + " has logged in");
			
			
		}
		else
		{
			req.setAttribute("useyName", "User");
		}
		
		//Calls the index.jsp file containing the html and css
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
}
