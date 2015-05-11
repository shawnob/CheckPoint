package ycp.cs320.spring15.persist;

import java.util.ArrayList;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.Question;
import ycp.cs320.spring15.model.Quiz;
import ycp.cs320.spring15.model.User;

public interface IDatabase {
	
	//Decelerations call methods in FakeDatabase
	public User findUser(String username, String password);
	public Course findCourse(String courseName);
	public User createAccount(String username, String password, String firstname, String lastname, String email);
	public User searchUserByEmail(String email);
	public boolean addQuestion(String question, String choices[], String correctAnswer);
	public ArrayList<String> getTeacherCourseList(String username);
	public ArrayList<String> getStudentCourseList(String username);
	
	// TODO:
	public Quiz createQuiz(String quizName, User instructor, Course course);
	
	public Question addQuestion(int type, String question, String choices[], int correctAnswer);
	public boolean isUserTeacher(String username, String coursename);
	public String[] retquestchoices(int quizID, int questionNum);

	
	//public Question addQuestion(int type, String question, String choices[], int correctAnswer);
	public String retquest(int QuizID, int questionnum);
	public int retquestnum(int QuizID, int QuestionNum);

	public Question addQuestion(int quizID,int questionNum, int type, String question, String choices[], int correctAnswer);
	public int addQuiz(String quizName, User instructor, Course course);
	public Quiz getQuiz(int ID);
	public boolean checkAnswer(int quizID, String FIBanswer, int MCanswer);
	public void addCourseAssociation(String username, String coursename, boolean isTeacher);
	public boolean userExists(String username);
	public boolean isStudentInClass(String username, String coursename);
}
