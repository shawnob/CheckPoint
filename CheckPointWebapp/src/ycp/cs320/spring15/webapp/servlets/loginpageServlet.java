package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.spring15.model.User;





public class loginpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/loginpage.jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		User user1 = new User("zaphod", "42");
		
		
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
		
		if (username.equals(user1.getUsername()) && password.equals(user1.getPassword())){ 
			login = true;
			result = "Passed";
		}
		else{
			login = false;
			result = "Login Failed";
		}
		
		// Add parameters as request attributes
		req.setAttribute("first", req.getParameter("username"));
		req.setAttribute("second", req.getParameter("password"));
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);
		
		// Forward to view to render the result HTML document
		if (login == true){
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		if (login == false){
		req.getRequestDispatcher("/_view/loginpage.jsp").forward(req, resp);
		}
	}
}
