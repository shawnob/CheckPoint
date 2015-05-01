package ycp.cs320.spring15.persist;

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
	
	
	// TODO:
	public void createQuiz(String quizName, User instructor, Course course);
	
	//public Question addQuestion(int type, String question, String choices[], int correctAnswer);
	public String retquest(int QuizID);
	public int retquestnum(int QuizID);

	// TODO
	public Question addQuestion(int quizID, int type, String question, String choices[], int correctAnswer);
	public int addQuiz(String quizName, User instructor, Course course);
	public Quiz getQuiz(int ID);
	public boolean checkAnswer(int quizID, String FIBanswer, int MCanswer);
}
