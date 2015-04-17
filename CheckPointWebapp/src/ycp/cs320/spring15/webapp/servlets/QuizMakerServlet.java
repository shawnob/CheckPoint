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
		String question = req.getParameter("question");
		String choiceA = req.getParameter("choiceA");
		String choiceB = req.getParameter("choiceB");
		String choiceC = req.getParameter("choiceC");
		String CorrectChoice = req.getParameter("correctChoice");
		
		//If nothing is entered and by making an empty string
		if (question == null){
			question = "";
		}
		
		if (choiceA == null){
			choiceA = "";
		}
		if (choiceB == null){
			choiceB = "";
		}
		if (choiceC == null){
			choiceC = "";
		}
		if (CorrectChoice == null){
			CorrectChoice = "";
		}
		
		//Call Controller which is now in webapp.servlets
		String[] choices = {choiceA,choiceB,choiceC};
		System.out.println(CorrectChoice);
		Controller controller = new Controller();
		controller.addQuestion(question, choices, CorrectChoice);
		/*User user =  controller.signIn(username, password);
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
		*/
	}
}
