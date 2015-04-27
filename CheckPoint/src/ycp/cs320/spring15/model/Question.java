package ycp.cs320.spring15.model;

public class Question {
	//correct answers for multiple choice and fill in the blank
	private int correctAnswer;
	private int type;
	private String[] choices;
		
	public Question(int type,String question,String choices[],int correctAnswer ){
		this.type = type;
		this.correctAnswer = correctAnswer; 
		this.setChoices(choices);
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
	
	public int getCorrectAns() {
		return correctAnswer;
	}
	
	public void setCorrectAns(int ans) {
		correctAnswer = ans;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String choices[]) {
		this.choices = choices;
	}

}