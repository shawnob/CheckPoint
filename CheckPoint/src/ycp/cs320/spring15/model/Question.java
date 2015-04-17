package ycp.cs320.spring15.model;

public class Question {
	//correct answers for multiple choice and fill in the blank
	private int correctAnswerMC;
	private String correctAnswerFIB;
	private int type;
		
	//Constructors for MC and FIB respectively 
	public Question(int type, int correctAnswerMC){
		this.type = type;
		this.correctAnswerMC = correctAnswerMC;
	}
	
	public Question(int type, String correctAnswerFIB){
		this.type = type;
		this.correctAnswerFIB = correctAnswerFIB;
	}
	
	// Multiple Choice and Fill in the Blank respectively.
	public void questionType(int type) {
		this.type = type;
	}
		
	public void setQuestionType(int type) {
		this.type = type;
	}
		
	public int getQuestionType() {
		return this.type;
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
