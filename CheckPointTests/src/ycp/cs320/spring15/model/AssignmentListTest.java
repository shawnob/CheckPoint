package ycp.cs320.spring15.model;

//Finished//

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AssignmentListTest {
	
	private AssignmentList aList1;
	private AssignmentList aList2;
	private AssignmentList aList3;
	
	private Assignment testAssignment1;
	private Assignment testAssignment2;
	private Assignment testAssignment3;
	
	@Before
	public void setUp() {
		aList1 = new AssignmentList();
		aList2 = new AssignmentList();
		aList3 = new AssignmentList();
		
		testAssignment1 = new Assignment();
		testAssignment1.setNumberOfQuestions(3);
		testAssignment1.setAssignmentName("Meaning of Life");
		
		testAssignment2 = new Assignment();
		testAssignment2.setNumberOfQuestions(0);
		testAssignment2.setAssignmentName("Testing 0 questions");
		
		testAssignment3 = new Assignment();
		testAssignment3.setNumberOfQuestions(4);
		testAssignment3.setAssignmentName("How to sleep");
	}
	
	
	//There were no ways to add to AssignmentList
	@Test
	public void testGetAssignment() {

	}
}
