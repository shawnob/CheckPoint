package ycp.cs320.spring15.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	
	@Before
	public void setUp() {
		user = new User("testuser", "mypasswd");
	}
	
	@Test
	public void testGetUsername() {
		assertEquals("testuser", user.getUsername());
	}
}
