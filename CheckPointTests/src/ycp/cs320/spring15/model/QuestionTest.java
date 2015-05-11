package ycp.cs320.spring15.model;

//Finished//

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuestionTest {
	private Question question1;
	private Question question2;
	private Question question3;
	
	private String[] question1Strings;
	private String[] question2Strings;
	private String[] question3Strings;

	
	@Before
	public void setUp() {
		question1Strings = new String[4];
		question2Strings = new String[2];
		question3Strings = new String[1];
		
		question1Strings[0] = "Option 1";
		question1Strings[1] = "Option 2";
		question1Strings[2] = "Option 3";
		question1Strings[3] = "Option 4";
		
		question2Strings[0] = "True";
		question2Strings[1] = "False";
		
		question3Strings[0] = "test";
		
		// FIXME: are the question numbers reasonable?
		question1 = new Question(0, 1, "Aggregation represents what kind of association?", question1Strings, 3);
		question2 = new Question(1, 2, "What is the meaning of life?", question2Strings, 0);
		question3 = new Question(2, 3, "How now brown cow?", question3Strings, 0);
	}

	@Test
	public void testSetQuestionType() {
		question1.questionType(0);
		assertEquals(0, question1.getQuestionType());
		question1.setQuestionType(1);
		assertEquals(1, question1.getQuestionType());
		
		question2.questionType(1);
		assertEquals(1, question2.getQuestionType());
		question2.setQuestionType(0);
		assertEquals(0, question2.getQuestionType());
		
		question3.questionType(0);
		assertEquals(0, question3.getQuestionType());
		question3.setQuestionType(0);
		assertEquals(0, question3.getQuestionType());
	}
	
	@Test
	public void testGetQuestionType() {
		assertEquals(0, question1.getQuestionType());
		assertEquals(1, question2.getQuestionType());
		assertEquals(2, question3.getQuestionType());
	}
	
	@Test
	public void testGetCorrectAns() {
		assertEquals(3, question1.getCorrectAns());
		assertEquals(0, question2.getCorrectAns());
		assertEquals(0, question3.getCorrectAns());
	}
	
	@Test
	public void testSetCorrectAns() {
		question1.setCorrectAns(2);
		assertEquals(2, question1.getCorrectAns());
		question2.setCorrectAns(4);
		assertEquals(4, question2.getCorrectAns());
		question3.setCorrectAns(7);
		assertEquals(7, question3.getCorrectAns());
	}

	@Test
	public void testGetChoices() {
		assertEquals(question1Strings, question1.getChoices());
		assertEquals(question2Strings, question2.getChoices());
		assertEquals(question3Strings, question3.getChoices());
	}
	
	@Test
	public void testGetUniqueID() {
		assertEquals(0,question1.getUniqueID());
		assertEquals(0,question2.getUniqueID());
		assertEquals(0,question3.getUniqueID());
	}
	
	@Test
	public void testSetUniqueID() {
		question1.setUniqueID(24);
		assertEquals(24,question1.getUniqueID());
		question2.setUniqueID(42);
		assertEquals(42,question2.getUniqueID());
		question3.setUniqueID(3);
		assertEquals(3,question3.getUniqueID());
	}
	
	@Test
	public void testGetQuestion() {
		assertEquals("Aggregation represents what kind of association?", question1.getQuestion());
		assertEquals("What is the meaning of life?", question2.getQuestion());
		assertEquals("How now brown cow?", question3.getQuestion());
	}

	@Test
	public void testSetQuestion() {
		question1.setQuestion("why?");
		assertEquals("why?", question1.getQuestion());
		question2.setQuestion(null);
		assertEquals(null, question2.getQuestion());
		question3.setQuestion("");
		assertEquals("", question3.getQuestion());
	}
	
	@Test
	public void testCheckAnswer() {
		assertEquals(true, question1.CheckAnswer(null, 3));
		assertEquals(false, question2.CheckAnswer(null, 0));
		assertEquals(false, question3.CheckAnswer(null, 0));
	}
}
