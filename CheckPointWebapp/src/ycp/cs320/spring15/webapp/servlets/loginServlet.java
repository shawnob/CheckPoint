package ycp.cs320.spring15.webapp.servlets;

/*Created by Shawn O'Brien 3/12/2015
 * Login functionality 
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.spring15.model.User;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Welcome to Checkpoint!");
		User test = new User("ben", "hello");
		

		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
}
