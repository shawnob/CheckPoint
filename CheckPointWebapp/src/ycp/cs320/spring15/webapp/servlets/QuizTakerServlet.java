package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.FakeDatabase;
import ycp.cs320.spring15.persist.IDatabase;




public class QuizTakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doGetT called");
		Controller controller = new Controller();
		
		
		
		/////////
		
		String answer = req.getParameter("answer");
		String question = controller.retquest();
		int type = controller.retquesttype();
		int questionnum = controller.retquestnum();
		
		
		//If nothing is entered and by making an empty string
		if (answer == null){
			answer = "";
		}
		
		req.setAttribute("questionnum", questionnum);
		req.setAttribute("question", question);
		req.setAttribute("type", type);
		
		
		
		
		
		/////////////////////////////////////////////////////////////////
		
		
		//Calls the login.jsp file containing the html and css
		req.getRequestDispatcher("/_view/quiztaker.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doPostT called");

		// Decode form parameters and dispatch to controller
		
	}
}
