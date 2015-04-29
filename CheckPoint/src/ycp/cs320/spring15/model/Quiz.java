package ycp.cs320.spring15.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
	
	private String quizName;
	private ArrayList<Question> questionList;
	

	public Quiz(String quizName){
		this.quizName = quizName;
		questionList = new ArrayList<Question>();
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
	
}