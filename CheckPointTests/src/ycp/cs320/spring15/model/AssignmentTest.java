package ycp.cs320.spring15.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AssignmentTest {
	
	//test variable
	private Assignment testAssignment;
	
	@Before
	public void setup() {
		
		testAssignment = new Assignment();
		testAssignment.setQuestionType(true);
		testAssignment.setNumberOfQuestions(3);
		testAssignment.setAssignmentName("Meaning of Life");
	}
	
}
