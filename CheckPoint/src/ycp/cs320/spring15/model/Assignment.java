package ycp.cs320.spring15.model;

import java.util.*;

public class Assignment {
	
	//false for Multiple Choice, true for Fill in the Blank
	private boolean questionType;
	private String assignmentName;
	private int numberOfQuestions;
	
	/*
	 * Getter and setter methods
	 */
	public boolean getQuestionType() {
		return questionType;
	}
	
	public void setQuestionType(boolean type){
		questionType = type;
	}
	
	public String getAssignmentName() {
		return assignmentName;
	}
	
	public void setAssignmentName(String name) {
		assignmentName = name;
	}
	
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	
	public void setNumberOfQuestions(int num) {
		numberOfQuestions = num;
	}
	
	
}