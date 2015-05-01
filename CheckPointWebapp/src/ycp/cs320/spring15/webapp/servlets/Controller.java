package ycp.cs320.spring15.webapp.servlets;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.Quiz;
import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.IDatabase;

public class Controller {

	//Controller for the WebApp. 
	//Calls IDatabase whic is linked to the FakeDatabase
	///////////////////////
	////////User///////////
	//////////////////////
	
	public User signIn(String username, String password) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.findUser(username, password);
	}
	
	public User createAccount(String username, String password, String firstname, String lastname, String email) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.createAccount(username, password, firstname, lastname, email);
	}
	
	public User searchUserByEmail(String email){
		IDatabase db = DatabaseProvider.getInstance();
		return db.searchUserByEmail(email);
	}
	
	public Course findCourseByCourseName(String courseName)
	{
		IDatabase db = DatabaseProvider.getInstance();
		return db.findCourse(courseName);
	}

	///////////////////////
	/////Questions/////////
	//////////////////////
	public void questionList(User user, Course course){
		
	}
	public boolean addQuestion(int quizID, int type,String question,String[] choices,int correctAnswer){
		IDatabase db = DatabaseProvider.getInstance();
		db.addQuestion(quizID, type, question, choices, correctAnswer);
		return true;
	}
	
	public String retquest (int quizID){
		IDatabase db = DatabaseProvider.getInstance();
		String test = db.retquest(quizID);
		return test;
	}
	
	public int retquestnum (int quizID){
		IDatabase db = DatabaseProvider.getInstance();
		int qnum = db.retquestnum(quizID);
		return qnum;
	}
	public int addQuiz(String quizName, User instructor, Course course){
		IDatabase db = DatabaseProvider.getInstance();
		return db.addQuiz(quizName, instructor, course);
	}
	public Quiz getQuiz(int ID){
		IDatabase db = DatabaseProvider.getInstance();
		return db.getQuiz(ID);
	}
	
}
