package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import ycp.cs320.spring15.model.Quiz;
import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.FakeDatabase;
import ycp.cs320.spring15.persist.IDatabase;




public class QuizTakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int questionnum = 0;
	private int rcount = 0;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("doGetT called");
		//System.out.println(questionnum);
		Controller controller = new Controller();

		int quizID = 666;

		//int questionnum = controller.retquestnum(quizID);
		String question = controller.retquest(quizID, questionnum);
		int type = controller.getQuiz(quizID).getQuestion(questionnum).getQuestionType();
		String[] choices = controller.retquestchoices(quizID, questionnum);
		Quiz theQuiz = controller.getQuiz(quizID);

		req.setAttribute("rcount", rcount);
		System.out.println(theQuiz.getQuestion(questionnum).getQuestionType());
		if (theQuiz.getQuestion(questionnum).getQuestionType() == 1){
			req.setAttribute("choice1", choices[0]);
			req.setAttribute("choice2", choices[1]);
			req.setAttribute("choice3", choices[2]);
		}
		req.setAttribute("questionnum", questionnum);
		req.setAttribute("question", question);
		req.setAttribute("type", type);


		//req.setAttribute("answer", answer);

		questionnum++;

		//Calls the login.jsp file containing the html and css
		//doPost(req, resp);
		req.getRequestDispatcher("/_view/quiztaker.jsp").forward(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Controller controller = new Controller();
		Quiz theQuiz = controller.getQuiz(666);
		System.out.println("doPostT called");

		String answer = req.getParameter("submited");

		System.out.println("A=" + answer);

		if (theQuiz.getQuestion(questionnum-1).getQuestionType() == 1){
			String[] choices = controller.retquestchoices(666, questionnum-1);
			int checked = 0;	
			if (answer.equals(choices[0])){
				checked = 0;
			}
			if (answer.equals(choices[1])){
				checked = 1;
			}
			if (answer.equals(choices[2])){
				checked = 2;
			}

			if (controller.getQuiz(666).getQuestion(questionnum-1).getCorrectAns() == checked){
				//req.setAttribute("result", "Correct!");
				rcount++;
			}else{
				//req.setAttribute("result", "Incorrect!");
			}
		}

		if (theQuiz.getQuestion(questionnum-1).getQuestionType() == 0){
			
			int answer2 = Integer.parseInt(answer);
			
			if (controller.getQuiz(666).getQuestion(questionnum-1).getCorrectAns() == answer2){
				//req.setAttribute("result", "Correct!");
				rcount++;
			}else{
				//req.setAttribute("result", "Incorrect!");
			}
		}
		
		if (theQuiz.getNumQuestions() == questionnum) {
			questionnum = 0;
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}else{
			doGet(req, resp);
		}

	}
}
