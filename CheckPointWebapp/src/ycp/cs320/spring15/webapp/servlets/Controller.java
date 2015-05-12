package ycp.cs320.spring15.webapp.servlets;

import java.util.ArrayList;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.Quiz;
import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DBUtil;
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
	
	/////////////////////
	/////Course/////////
	///////////////////
	
	public Course findCourseByCourseName(String courseName)
	{
		IDatabase db = DatabaseProvider.getInstance();
		return db.findCourse(courseName);
	}
	
	public ArrayList<String> getStudentCourseListByUsername (String username)
	{
		IDatabase db = DatabaseProvider.getInstance();
		return db.getStudentCourseList(username);
	}
	
	public ArrayList<String> getTeacherCourseListByUsername (String username)
	{
		IDatabase db = DatabaseProvider.getInstance();
		return db.getTeacherCourseList(username);
	}
	
	public int addStudentToCourse(String cName, String student)
	{
		//returns 0 as generic failure, 1 as success, 2 as student already added and 3 as student does not exist
		IDatabase db = DatabaseProvider.getInstance();
		
		if(!db.userExists(student))
		{
			return 3;
		}
		
		if (db.isUserTeacher(student, cName) || db.isStudentInClass(student, cName))
		{
			return 2;
		}
		
		db.addCourseAssociation(student, cName, false);
		
		if(db.isStudentInClass(student, cName))
		{
			return 1;
		}
		return 0;
	}
	
	

	///////////////////////
	/////Questions/////////
	//////////////////////
	public void questionList(User user, Course course){
		
	}
	public boolean addQuestion(int quizID,int questionNum, int type,String question,String[] choices,int correctAnswer){
		IDatabase db = DatabaseProvider.getInstance();
		db.addQuestion(quizID,questionNum, type, question, choices, correctAnswer);
		return true;
	}
	
	public String retquest (int quizID, int questionnum){
		IDatabase db = DatabaseProvider.getInstance();
		String test = db.retquest(quizID, questionnum);
		return test;
	}
	
	public int retquestnum (int quizID){
		IDatabase db = DatabaseProvider.getInstance();
		int qnum = db.retquestnum(quizID, 0);//TODO FIX THIS
		return 0;
	}
	public int addQuiz(String quizName, User instructor, String course){
		IDatabase db = DatabaseProvider.getInstance();
		return db.addQuiz(quizName, instructor, course);
	}
	public Quiz getQuiz(int ID){
		IDatabase db = DatabaseProvider.getInstance();
		return db.getQuiz(ID);
	}

	public boolean isUserTeacher(String username, String coursename) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.isUserTeacher(username, coursename);
	}
	
	public int retquesttype(int ID, int QuestionNum) {
		IDatabase db = DatabaseProvider.getInstance();
		int qnum = db.retquestnum(ID,QuestionNum);
		return qnum;
	}

	public String[] retquestchoices(int quizID, int questionNum) {
		// TODO Auto-generated method stub
		IDatabase db = DatabaseProvider.getInstance();
		return db.retquestchoices(quizID, questionNum);
	}

	public ArrayList<Quiz> getQuizList(
			String coursename) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.getQuizList(coursename);
	}
}
