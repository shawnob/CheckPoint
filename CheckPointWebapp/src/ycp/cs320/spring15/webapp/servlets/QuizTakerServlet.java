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
	private int check = 0;
	private int other = 0;
	private int quizID = 0;
	private int other2 = 0;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGetT called");

		//System.out.println(questionnum);
		Controller controller = new Controller();

		if (other2 == 0){

			String quizPath = req.getPathInfo();

//			if (quizPath == null || quizPath.equals("/"))
//			{
//				resp.sendRedirect(req.getContextPath() + "/index");
//				System.out.println("ind");
//			}
//			else
//			{
				System.out.println("subs");
				quizPath = quizPath.substring(1);
//			}

			quizID = Integer.parseInt(quizPath);
			other2++;
			

		}

		if (other == 0){
			
			String question = controller.retquest(quizID, questionnum);
			int type = controller.getQuiz(quizID).getQuestion(questionnum).getQuestionType();
			String[] choices = controller.retquestchoices(quizID, questionnum);
			Quiz theQuiz = controller.getQuiz(quizID);

			if (questionnum == 0){
				check = 0;
				rcount = 0;
			}

			req.setAttribute("rcount", rcount);
			req.setAttribute("check", check);

			if (theQuiz.getQuestion(questionnum).getQuestionType() == 0){
				req.setAttribute("choice1", choices[0]);
				req.setAttribute("choice2", choices[1]);
				req.setAttribute("choice3", choices[2]);
			}
			req.setAttribute("questionnum", questionnum);
			req.setAttribute("question", question);
			req.setAttribute("type", type);
			questionnum++;

		}else{
			System.out.println("doGetT2 called");
			Quiz theQuiz = controller.getQuiz(quizID);

			int type = 3;
			req.setAttribute("type", type);
			req.setAttribute("rcount", rcount);
			req.setAttribute("questionnum", theQuiz.getNumQuestions());

		}
		req.getRequestDispatcher("/_view/quiztaker.jsp").forward(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPostT called");
		
		Controller controller = new Controller();

		Quiz theQuiz = controller.getQuiz(quizID);

		if (other != 1){
			String answer = req.getParameter("submited");
			System.out.println("A=" + answer);

			if (theQuiz.getQuestion(questionnum-1).getQuestionType() == 0){                  //multiple choice
				String[] choices = controller.retquestchoices(quizID, questionnum-1);
				int checked = 0;	
				if (answer.equals(choices[0])){
					checked = 1;
				}
				if (answer.equals(choices[1])){
					checked = 2;
				}
				if (answer.equals(choices[2])){
					checked = 3;
				}
				System.out.println(checked);
				if (controller.getQuiz(quizID).getQuestion(questionnum-1).getCorrectAns() == checked){
					rcount++;
					check = 1;
				}else{
					check = 2;
				}
			}
			
			if (theQuiz.getQuestion(questionnum-1).getQuestionType() == 1){                  //fill in the blank
				
				int answer2 = Integer.parseInt(answer);

				String[] choices = controller.retquestchoices(quizID, questionnum-1);
				int answer3 = Integer.parseInt(choices[0]);
				
				if (answer3 == answer2){
				//if (controller.getQuiz(666).getQuestion(questionnum-1).getCorrectAns() == answer2){
					rcount++;
					check = 1;
				}else{
					check = 2;
				}
			}

		}

		if ((theQuiz.getNumQuestions() == questionnum) && (other == 0)) {                         //no more questions
			questionnum = 0;
			other = 1;
			doGet(req, resp);
		}else if (other == 1){

			questionnum = 0;
			rcount = 0;
			check = 0;
			other = 0;
			other2 = 0;
			resp.sendRedirect(req.getContextPath() + "/index");
			//req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}else{
			doGet(req, resp);
		}

	}



}
