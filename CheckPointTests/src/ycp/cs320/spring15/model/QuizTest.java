//Note to self: Eclemma

package ycp.cs320.spring15.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuizTest {
	
	private Quiz quiz1;
	private Quiz quiz2;
	private Quiz quiz3;
	
	private User teacher;
	
	private Course CS320;
	
	private Question question1;
	private Question question2;
	private Question question3;
	
	private String[] question1Strings;
	private String[] question2Strings;
	private String[] question3Strings;
	
	@Before
	public void setUp()	{
		teacher = new User();
		
		CS320 = new Course("CS320");
		
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
		
		question1 = new Question(0, "Aggregation represents what kind of association?", question1Strings, 3);
		question2 = new Question(1, "What is the meaning of life?", question2Strings, 0);
		question3 = new Question(2, "How now brown cow?", question3Strings, 0);
		
		quiz1 = new Quiz("UML mult. choice", teacher, CS320, 0);
		quiz2 = new Quiz("Meaning of Life: Fill in the Blank", teacher, CS320, 1);
		quiz3 = new Quiz("Index error test", teacher, CS320, 2);
		
		quiz1.addQuestion(question1);
		quiz1.addQuestion(question2);
		quiz2.addQuestion(question2);
		quiz3.addQuestion(question3);
	}
	
	@Test
	public void testGetQuestion() {
		assertEquals("Aggregation represents what kind of association?", quiz1.getQuestion(0).getQuestion());
		assertEquals(question1, quiz1.getQuestion(0));
		assertNotEquals(question3, quiz1.getQuestion(1));
		assertEquals(question3, quiz3.getQuestion(0));
	}
	
	@Test
	public void test() {
		
	}
}
