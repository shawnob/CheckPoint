package ycp.cs320.spring15.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserListTest {
	//User Lists
	private UserList userList1 = new UserList();
	
	//Users
	private User user1 = new User("ben", "test");
	private User user2 = new User("zaphod", "beeblebrox");
	private User user3 = new User("arthur", "dent");
	
	
	
	@Before
	public void setUp(){
		//System.out.print(user1.getUsername() + user1.getPassword());
		userList1.addUser(user1);
	}

	@Test
	public void testContainsUser() throws Exception{
		assertTrue(userList1.containsUser("ben"));
	}
	
//	@Test
//	public void testGetUser(){
//		//TODO
//	}
	
	

}
