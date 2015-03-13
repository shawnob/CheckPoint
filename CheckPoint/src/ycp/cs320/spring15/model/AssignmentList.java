package ycp.cs320.spring15.model;

import java.util.*;

public class AssignmentList {

	private ArrayList<Assignment> assignmentList;
	
	public AssignmentList() {
		ArrayList<Assignment> assignmentList = new ArrayList<Assignment>(); 
	}
	
	/*
	 * Get an assignment from the array
	 */
	public Assignment getAssignment(String assignmentname) {
		Assignment temp;
		
		for (int i = 0; i < assignmentList.size(); i++){
			temp = assignmentList.get(i);
			System.out.println(temp.getAssignmentName());
			
			if (temp.getAssignmentName() == assignmentname){
				return temp;
			}
		}
		System.out.println("done");
		
		return null;
	}
	
	
}