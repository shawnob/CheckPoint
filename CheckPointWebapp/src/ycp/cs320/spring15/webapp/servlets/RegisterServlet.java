package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.IDatabase;




public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doGet called");
		
		//Calls the register.jsp file containing the html and css
		req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doPost called");
		
	
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		boolean create;
		String result = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String email2 = req.getParameter("email2");
		
		
		
		Controller controller = new Controller();
		User user;
		
		
		//If nothing is entered and by making an empty string
		if (username == null){
			username = "";
		}
		
		if (password == null){
			password = "";
		}
		if (password2 == null){
			password2 = "";
		}
		if (firstname == null){
			firstname = "";
		}
		if (lastname == null){
			lastname = "";
		}
		if (email == null){
			email = "";
		}
		if (email2 == null){
			email2 = "";
		}
		
		//First make sure passwords confirm to be the same
				if (password.equals(password2)){
					//Make sure emails match
					if (email.equals(email2)){
						//Make double check and make sure email adresse is not already used
						if (controller.searchUserByEmail(email) == null){
							user = controller.createAccount(username, password, firstname, lastname, email);
							if (user != null){
								create = true;
								result = "Success!";
								//Redirect to index page
								req.setAttribute("result", result);
								req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
							}
							else{
								//Username already exists 
								create = false;
								result = "Username already exists";
							}
						}
						else {
							create = false;
							result = "Email already exists";
						}
					}
					else{
						create=false;
						result = "Email adresse don't match";
					}
				}
				else{
					create=false;
					result = "Passwords don't match";
				}
		
		
		
		
		
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("password2", req.getParameter("password2"));
		req.setAttribute("firstname", req.getParameter("firstname"));
		req.setAttribute("lastname", req.getParameter("lastname"));
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("email2", req.getParameter("email2"));
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);
		
		
		//If login in failed redirect back to login page
		if (create == false){
		req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);
		}
	}
}
