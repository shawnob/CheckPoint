package ycp.cs320.spring15.model;

/*Created by Shawn O'Brien 3/12/2015*/


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserListTest {
	//User Lists
	private UserList userList = new UserList();
	
	//Users
	private User user1 = new User("ben", "somethinSpecial42");
	private User user2 = new User("zaphod", "beeblebrox");
	private User user3 = new User("arthur", "dent");
	
	
	
	@Before
	public void setUp(){
		//System.out.print(user1.getUsername() + user1.getPassword());
		userList.addUser(user1);
		userList.addUser(user2);
		userList.addUser(user3);
	}

	@Test
	public void testContainsUser() throws Exception{
		//True's
		assertTrue(userList.containsUser("ben"));
		assertTrue(userList.containsUser("zaphod"));
		assertTrue(userList.containsUser("arthur"));
		
		//False
		assertFalse(userList.containsUser("none"));
		assertFalse(userList.containsUser("trillian"));

	}
	
	@Test
	public void testGetUser(){
		assertEquals(user1, userList.getUser("ben"));
		assertEquals(user2, userList.getUser("zaphod"));
		assertEquals(user3, userList.getUser("arthur"));
	}
	
	@Test
	public void testCreateUser(){
		assertTrue(userList.CreateUser("aphex", "twin"));
		assertTrue(userList.CreateUser("elvis", "presely"));
		assertTrue(userList.CreateUser("wesley", "willis"));
	}
	
	@Test
	public void testDeleteUser(){
		userList.deleteUser(user1);
		assertFalse(userList.containsUser("ben"));
		
		userList.deleteUser(user2);
		assertFalse(userList.containsUser("zaphod"));
		
		userList.deleteUser(user3);
		assertFalse(userList.containsUser("arthur"));
	}

}
