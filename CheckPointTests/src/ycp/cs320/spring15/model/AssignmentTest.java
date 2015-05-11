package ycp.cs320.spring15.model;

//Finished//

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AssignmentTest {
	
	private Assignment testAssignment1;
	private Assignment testAssignment2;
	private Assignment testAssignment3;
	
	@Before
	public void setup() {
		
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
	
	@Test
	public void testGetAssignmentName() {
		assertEquals("Meaning of Life", testAssignment1.getAssignmentName());
		assertEquals("Testing 0 questions", testAssignment2.getAssignmentName());
		assertEquals("How to sleep", testAssignment3.getAssignmentName());
	}
	
	@Test
	public void testSetAssignmentName() {
		testAssignment1.setAssignmentName("Test 2");
		assertEquals("Test 2", testAssignment1.getAssignmentName());
		testAssignment2.setAssignmentName("Exhaust Fumes");
		assertEquals("Exhaust Fumes", testAssignment2.getAssignmentName());
		testAssignment3.setAssignmentName("Calculating the distance between:");
		assertEquals("Calculating the distance between:", testAssignment3.getAssignmentName());
	}
	
	@Test
	public void testGetNumberOfQuestions() {
		assertEquals(3, testAssignment1.getNumberOfQuestions());
		assertEquals(0, testAssignment2.getNumberOfQuestions());
		assertEquals(4, testAssignment3.getNumberOfQuestions());
	}
	
	@Test
	public void testSetNumberOfQuestions() {
		testAssignment1.setNumberOfQuestions(-3);
		assertEquals(-3, testAssignment1.getNumberOfQuestions());
		testAssignment2.setNumberOfQuestions(2);
		assertEquals(2, testAssignment2.getNumberOfQuestions());
		testAssignment3.setNumberOfQuestions(1);
		assertEquals(1, testAssignment3.getNumberOfQuestions());
	}
	
}
