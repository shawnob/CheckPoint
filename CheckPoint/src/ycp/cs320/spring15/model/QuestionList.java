package ycp.cs320.spring15.model;

import java.util.ArrayList;

public class QuestionList {
	
	private ArrayList<Question> questionList;

	public QuestionList(){
		questionList = new ArrayList<Question>();
	}
	
	//returns a question based on the index number of the question in our arraylist
	public Question getQuestion(int questionIndexNum){
		if(questionIndexNum > questionList.size())
			return null;
		else
			return questionList.get(questionIndexNum);
	}
	
}
