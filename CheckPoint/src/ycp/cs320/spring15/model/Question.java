package ycp.cs320.spring15.model;

public class Question {
	//correct answers for multiple choice and fill in the blank
	private int correctAnswerMC;
	private String correctAnswerFIB;
	private int type;
	private int numQuestions;
		public Question(int type, int numQuestions){
			this.type = type;
			this.numQuestions = numQuestions;
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
