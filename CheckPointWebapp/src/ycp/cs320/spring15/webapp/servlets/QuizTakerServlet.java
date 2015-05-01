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
		
		String question = controller.retquest(0);
		System.out.println("question=" + question);
		int questionnum = controller.retquestnum(0);
		System.out.println("questionnum=" + questionnum);
		
		//If nothing is entered and by making an empty string
		req.setAttribute("questionnum", questionnum);
		req.setAttribute("question", question);
		
		
		
		
		
		/////////////////////////////////////////////////////////////////
		
		
		//Calls the login.jsp file containing the html and css
		req.getRequestDispatcher("/_view/quiztaker.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Controller controller = new Controller();
		
		System.out.println("doPostT called");
		String answer = req.getParameter("answer");
		System.out.println("answer=" + answer);
		if(controller.getQuiz(0).getQuestion(0).CheckAnswer(answer, 0)){
			req.setAttribute("result", "Correct!");
		}else{
			req.setAttribute("result", "Incorrect!");
		}
		
		//req.setAttribute("errorMessage", errorMessage);
		//req.setAttribute("result", result);
		req.getRequestDispatcher("/_view/quiztaker.jsp").forward(req, resp);
		// Decode form parameters and dispatch to controller
		
	}
}
