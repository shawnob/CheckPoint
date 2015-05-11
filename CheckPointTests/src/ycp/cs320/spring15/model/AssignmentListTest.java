package ycp.cs320.spring15.model;

//Finished//

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AssignmentListTest {
	
	private AssignmentList aList;
	
	ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
	
	private Assignment testAssignment1;
	private Assignment testAssignment2;
	private Assignment testAssignment3;
	
	@Before
	public void setUp() {		
		aList = new AssignmentList();
		
		testAssignment1 = new Assignment();
		testAssignment1.setNumberOfQuestions(3);
		testAssignment1.setAssignmentName("Meaning of Life");
		
		testAssignment2 = new Assignment();
		testAssignment2.setNumberOfQuestions(0);
		testAssignment2.setAssignmentName("Testing 0 questions");
		
		testAssignment3 = new Assignment();
		testAssignment3.setNumberOfQuestions(4);
		testAssignment3.setAssignmentName("How to sleep");
		
		assignmentList.add(testAssignment1);
		assignmentList.add(testAssignment2);
		assignmentList.add(testAssignment3);
	}
	
	
	//There were no ways to add to AssignmentList
	@Test
	public void testGetAssignment() {
		assertEquals(null, aList.getAssignment("Meaning of Life"));
	}
}
