package ycp.cs320.spring15.webapp.servlets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.Quiz;
import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.persist.DBUtil;
import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.FakeDatabase;
import ycp.cs320.spring15.persist.IDatabase;
import ycp.cs320.spring15.persist.UserList;
import ycp.cs320.spring15.webapp.*;

public class ControllerTest {
	private Controller contTest;
	
	private IDatabase dbTest;
	
	private FakeDatabase db;
	
	private UserList listTest;
	
	private User userTest;
	
	private String course;
	
	@Before
	public void setUp() {
		listTest = new UserList();
		contTest = new Controller();
		userTest = new User("username","password","firstname","lastname","email");
		course =  "Calculus 3";
		
		listTest.addUser(userTest);

		db = new FakeDatabase();
	}
	
	@Test
	public void testSignIn() {
		userTest = db.createAccount("username", "password", "firstname", "lastname", "email");
		assertEquals(userTest, db.findUser("username", "password"));
	}
	
	@Test
	public void testSearchUserByEmail() {
		userTest = db.createAccount("username", "password", "firstname", "lastname", "email");
		assertEquals(userTest, db.searchUserByEmail("email"));
	}
	
	@Test
	public void testFindCourseByCourseName() {
		db.addQuiz("meh", userTest, course);
		assertEquals(null, db.findCourse("Calculus 3"));
	}	
}