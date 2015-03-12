package ycp.cs320.spring15.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.model.UserList;

public class logInTest {
	//User Lists
	private UserList userList1 = new UserList();
	private SignIn signIn = new SignIn();
	
	//Users
	private User user1 = new User("ben", "test");
	private User user2 = new User("zaphod", "beeblebrox");
	private User user3 = new User("arthur", "dent");
	
	
	
	@Before
	public void setUp(){
		//System.out.print(user1.getUsername() + user1.getPassword());
		userList1.addUser(user1);
		userList1.addUser(user2);
		userList1.addUser(user3);
	}

	@Test
	public void testLogIn() throws Exception{
		assertEquals(user1, signIn.signIn("ben", "test"));
		assertEquals(user2, signIn.signIn("zaphod", "beeblebrox"));
		assertEquals(user3, signIn.signIn("arthur", "dent"));
		
	}
	
//	@Test
//	public void testGetUser(){
//		//TODO
//	}
	
	

}
