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
		

	}
}
