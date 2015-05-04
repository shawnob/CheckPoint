package ycp.cs320.spring15.model;

import java.util.ArrayList;

public class Quiz {
	
	private String quizName;
	private ArrayList<Question> questionList;
	private User Teacher;
	private Course course;
	private int UniqueID;
	
	

	public Quiz(String quizName, User Teacher, Course course, int UniqueID ){
		this.quizName = quizName;
		questionList = new ArrayList<Question>();
		this.setTeacher(Teacher);
		this.setCourse(course);
		this.UniqueID = UniqueID;
		
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
	public String getQuizName() {
		return quizName;
	}
	
	public int getNumQuestions() {
		return questionList.size();
	}
	
	//returns a question based on the index number of the question in our arraylist
	public Question getQuestion(int questionIndexNum){
			return questionList.get(questionIndexNum); 
	}

	public void addQuestion(Question q) {
		questionList.add(q);
	}

	public User getTeacher() {
		return Teacher;
	}

	public void setTeacher(User teacher) {
		Teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getUniqueID() {
		return UniqueID;
	}

	public void setUniqueID(int uniqueID) {
		UniqueID = uniqueID;
	}
	
}