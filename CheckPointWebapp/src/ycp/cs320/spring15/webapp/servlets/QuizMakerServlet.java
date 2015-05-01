package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.IDatabase;




public class QuizMakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer quizID;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doGet called");
		
		// force user to choose the question type
		req.setAttribute("selectedNone", "selected");
		
		//Calls the login.jsp file containing the html and css
		req.getRequestDispatcher("/_view/quizmaker.jsp").forward(req, resp);
		
		//create quiz
		//Controller controller = new Controller();
		//quizID = controller.addQuiz("Fist Quiz", null, null);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("doPost called");
		
	
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		//boolean login;
		String result = null;
		
		boolean[] selected = {true,true,true};
		boolean CreateNewQuiz = false;
		int correctAnswer = 4;
		Controller controller = new Controller();
		if(quizID == null){CreateNewQuiz = true;};
		
		String questionType = req.getParameter("questionType");
		String quizName = req.getParameter("quizName");
		if(CreateNewQuiz){
			quizID = controller.addQuiz(quizName, controller.signIn("Marvin", "42"), new Course("CS320"));
		}
		//If nothing is entered and by making an empty string
		if(questionType.equals("MC")){
			String question = req.getParameter("question");
			String choice1 = req.getParameter("choice1");
			String choice2 = req.getParameter("choice2");
			String choice3 = req.getParameter("choice3");
			String select1 = req.getParameter("select1");
			String select2 = req.getParameter("select2");
			String select3 = req.getParameter("select3");
			
			if (question == null){
				result = "Please enter a question.";
				question = "";
			}
			if (choice1 == null){
				choice1 = "";
			}
			if (choice2 == null){
				choice2 = "";
			}
			if (choice3 == null){
				choice3 = "";
			}
			if (select1 == null){
				selected[0] = false;
			}
			if (select2 == null){
				selected[1] = false;
			}
			if (select3 == null){
				selected[2] = false;
			}
			int correct = 0;
			for(int i = 0; i < 3;i++){
				if(selected[i]){
					correctAnswer = i+1;
					correct++;
				}
			}
			if(correct != 1){
				result = "Please chose one correct answer.";
			}
			
			//Call Controller which is now in webapp.servlets
			if(result != null){
				String[] choices = {choice1,choice2,choice3};
				controller.addQuestion(quizID,0, question, choices, correctAnswer);
			}
			req.setAttribute("question", req.getParameter("question"));
			
			req.setAttribute("choice1", req.getParameter("choice1"));
			req.setAttribute("choice2", req.getParameter("choice2"));
			req.setAttribute("choice3", req.getParameter("choice3"));
			
			req.setAttribute("select1", req.getParameter("select1"));
			req.setAttribute("select2", req.getParameter("select2"));
			req.setAttribute("select3", req.getParameter("select3"));
			
			req.setAttribute("quizName",req.getParameter("quizName"));
			
			req.setAttribute("selectedMC", "selected"); // make MC the default
			System.out.println("setting selectedMC=selected");
			
		}else if (questionType.equals("FIB")) {
			String FIBquestion = req.getParameter("FIBquestion");
			String[] FIBAnswer = {req.getParameter("FIBAnswer")};
			
			if(FIBquestion == null || FIBAnswer[0] == null){
				result = "Please Enter A Question And Answer";
			}else{
				
				controller.addQuestion( quizID, 1, FIBquestion,FIBAnswer,0);
			}
			req.setAttribute("FIBquestion", req.getParameter("FIBquestion"));
			req.setAttribute("FIBAnswer", req.getParameter("FIBAnswer"));
			req.setAttribute("quizName",req.getParameter("quizName"));
			req.setAttribute("selectedFIB", "selected"); // make FIB the default
			System.out.println("setting selectedFIB=selected");
		}
		// Add result objects as request attributes
		if(result == null){
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}else{
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);
		req.getRequestDispatcher("/_view/quizmaker.jsp").forward(req, resp);
		}
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
