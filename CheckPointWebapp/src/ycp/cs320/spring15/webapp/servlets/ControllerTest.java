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
	
	private UserList listTest;
	
	private User userTest;
	
	@Before
	public void setUp() {
		listTest = new UserList();
		contTest = new Controller();
		userTest = new User("username","password","firstname","lastname","email");
		
		DatabaseProvider.setInstance(dbTest);
		
		listTest.addUser(userTest);
		
		//dbTest.createAccount("username", "password", "firstname", "lastname", "email");
	}
	
	@Test
	public void testSignIn() {
		dbTest = DatabaseProvider.getInstance();
		assertEquals(userTest, dbTest.findUser("username", "password"));
	}
	
	
}