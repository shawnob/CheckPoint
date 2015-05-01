package ycp.cs320.spring15.model;

public class Question {
	//correct answers for multiple choice and fill in the blank
	private int type;
	private String question;
	private String[] choices;
	private int correctAnswer;
	private int UniqueID;
		
	public Question(int type,String question,String choices[],int correctAnswer ){
		this.type = type;
		this.question = question;
		this.setChoices(choices);
		this.correctAnswer = correctAnswer; 
	}
	// Multiple Choice and Fill in the Blank respectively.
	
	public String getQuestion() {
		return question;
	}

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

	public int getUniqueID() {
		return UniqueID;
	}

	public void setUniqueID(int uniqueID) {
		UniqueID = uniqueID;
	}

}