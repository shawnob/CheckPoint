package ycp.cs320.spring15.model;

public class Question {
	
	// Multiple Choice and Fill in the Blank respectively.
	public enum questionType{
		MC(0), FIB(1);
		
		private int type;
		
		private questionType(int type) {
			this.type = type;
		}
		
		public void setQuestionType(int type) {
			this.type = type;
		}
		
		public int getQuestionType() {
			return this.type;
		}
	}
	
	//correct answers for multiple choice and fill in the blank
	private int correctAnswerMC;
	private String correctAnswerFIB;
		
	//getter/setter
	
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
