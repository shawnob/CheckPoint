package ycp.cs320.spring15.model;

public class Question {
	//correct answers for multiple choice and fill in the blank
	private int type;
	private String question;
	private String[] choices;
	private int correctAnswer;
	private int UniqueID;
	private int index;
	
	public Question(int type,int questionNum,String question,String choices[],int correctAnswer){
		this.type = type;
		this.question = question;
		this.setChoices(choices);
		this.correctAnswer = correctAnswer;
		this.index = questionNum;
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

	public int getUniqueID() {
		return UniqueID;
	}

	public void setUniqueID(int uniqueID) {
		UniqueID = uniqueID;
	}

	public boolean CheckAnswer(String FIBanswer, int MCAnswer) {
		if(type == 0){
			return MCAnswer == this.correctAnswer;
		}else if (type == 1){
			return FIBanswer == this.choices[0];
		}else{
			return false;
		}
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
