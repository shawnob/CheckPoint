package ycp.cs320.spring15.model;

public class Question {
	
	//false for Multiple Choice, true for Fill in the Blank
	private boolean questionType;
	//correct answers for multiple choice and fill in the blank
	private int correctAnswerMC;
	private String correctAnswerFIB;
	
	//getter/setter
	public boolean questionType() {
		return questionType; 
	}
	
	public void setQuestionType(boolean type) {
		questionType = type;
	}
	
	public int getCorrectAnsMC() {
		return correctAnswerMC;
	}
	
	public void setCorrectAnsMC(int ans) {
		correctAnswerMC = ans;
	}
	
	public String getCorrectAnsFIB() {
		return correctAnswerFIB;
	}
	
	public void setCorrectAnsFIB(String ans) {
		correctAnswerFIB = ans;
	}

}
