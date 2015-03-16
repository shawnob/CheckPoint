package ycp.cs320.spring15.model;

import java.util.*;

public class Assignment {
	
	private ArrayList<Question> question = new ArrayList<Question>();
	private String assignmentName;
	private int numberOfQuestions;
	
	/* 
	 * Getter and setter methods
	 */
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