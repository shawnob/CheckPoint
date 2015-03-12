package ycp.cs320.spring15.model;

public class AssignmentList {

	private Assignment[] assignment;
	
	/*
	 * Get an assignment from the array
	 */
	public Assignment getAssignment(int assignmentNumber) {
		return assignment[assignmentNumber];
	}
	
	//todo:implement
}