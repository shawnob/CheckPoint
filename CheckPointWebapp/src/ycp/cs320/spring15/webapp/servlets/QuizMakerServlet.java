package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.IDatabase;




public class QuizMakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doGet called");
		
		//Calls the login.jsp file containing the html and css
		req.getRequestDispatcher("/_view/quizmaker.jsp").forward(req, resp);
		
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
		
		//If nothing is entered and by making an empty string
		if (username == null){
			username = "";
		}
		
		if (password == null){
			password = "";
		}
		
		//Call Controller which is now in webapp.servlets
		Controller controller = new Controller();
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
		
		//If login in failed redirect back to login page
		if (login == false){
		req.getRequestDispatcher("/_view/quizmaker.jsp").forward(req, resp);
		}
	}
}
