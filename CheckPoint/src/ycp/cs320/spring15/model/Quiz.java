package ycp.cs320.spring15.model;

import java.util.ArrayList;

public class Quiz {
	
	private String quizName;
	private ArrayList<Question> questionList;
	private User Teacher;
	private String course;
	private int UniqueID;
	private String strID;
	
	

	public Quiz(String quizName, User Teacher, String course, int UniqueID ){
		this.quizName = quizName;
		questionList = new ArrayList<Question>();
		this.setTeacher(Teacher);
		this.course = course;
		this.UniqueID = UniqueID;
		strID = ("" + UniqueID);
		
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
			//return questionList.get(questionIndexNum); 
		for (Question q : questionList) {
			if(q.getIndex() == questionIndexNum){
				return q;
			}
		}
		throw new IllegalStateException("No such question (num=" + questionIndexNum + ")");
		
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getUniqueID() {
		return UniqueID;
	}

	public void setUniqueID(int uniqueID) {
		UniqueID = uniqueID;
		strID = ("" + uniqueID);
	}
	
	public String getstrID()
	{
		return strID;
	}
	
}