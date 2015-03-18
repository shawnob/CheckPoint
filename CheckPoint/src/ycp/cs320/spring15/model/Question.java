package ycp.cs320.spring15.model;

public class Question {
	
	/*
	// Multiple Choice and Fill in the Blank respectively.
	public enum questionType{
		MC(0), FIB(1);
		
		public int TYPE;
		
		private Question(int type) {
			TYPE = type;
		}
		
		private int getQuestionType() {
			return TYPE;
		}
	}*/
	
	//false for Multiple Choice, true for Fill in the Blank
	private boolean questionType;
	//correct answers for multiple choice and fill in the blank
	private int correctAnswerMC;
	private String correctAnswerFIB;
	/*
	public Question(enum type, int correctAns) {
		
	}
	
	public Question(enum type, String correctAns) {
		
	}*/
	
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
