package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.spring15.controller.SignInToBedeleted;
import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.IDatabase;




public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doGet called");
		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doPost called");
		
	
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		boolean login;
		String result = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username == null){
			username = "";
		}
		
		if (password == null){
			password = "";
		}
		
		SignIn controller = new SignIn();
		User user =  controller.signIn(username, password);
		if (user != null) {
			// successful login
			login = true;
			result = "Passed";
			
		// User is now logged in
			User userNew = new User(username, password, null, null, null);
		   req.getSession().setAttribute("user", userNew);
			
			// Redirect to index page
			resp.sendRedirect(req.getContextPath() + "/index");
			return;
		} 
		else {
			// invalid username/password
			login = false;
			result = "Login Failed";
		}
		
		
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);
		
		// Forward to view to render the result HTML document
		/*
		if (login == true){
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		*/
		if (login == false){
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
	}
}
