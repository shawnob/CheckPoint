package ycp.cs320.spring15.model;


/*Created by Shawn O'Brien 3/12/2015*/
//Finished//



import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user1;
	private User user2;
	private User user3;
	
	private User emptyTest;
	
	@Before
	public void setUp() {
		user1 = new User("testuser", "mypassword", "bob", "dylan", "yes@ycp.edu");
		user1.setId(1);
		user2 = new User("zaphod", "beeblebrox", "noname", "mcgee", "ceo@google.com");
		user2.setId(20);
		user3 = new User("arthur", "dent", "arthur", "dent", "dogsleepingonmyfloor@zackshouse.com");
		user3.setId(72);
		
		emptyTest = new User();
	}
	
	@Test
	public void testGetUsername() {
		assertEquals("testuser", user1.getUsername());
		assertEquals("zaphod", user2.getUsername());
		assertEquals("arthur", user3.getUsername());
	}
	
	@Test
	public void testSetUsername() {
		user1.setUsername("yesles");
		assertEquals("yesles", user1.getUsername());
		user2.setUsername("noi");
		assertEquals("noi", user2.getUsername());
		user3.setUsername("sometimes");
		assertEquals("sometimes", user3.getUsername());
	}
	
	@Test
	public void testGetPassword(){
		assertEquals("mypassword", user1.getPassword());
		assertEquals("beeblebrox", user2.getPassword());
		assertEquals("dent", user3.getPassword());
	}
	
	@Test
	public void testSetPassword(){
		user1.setPassword("notmypassword");
		assertEquals("notmypassword", user1.getPassword());
		user2.setPassword("trillian");
		assertEquals("trillian", user2.getPassword());
		user3.setPassword("slartibartfast");
		assertEquals("slartibartfast", user3.getPassword());
	}
	
	@Test
	public void testSetId() {
		user1.setId(1);
		assertEquals(1, user1.getId());
		user2.setId(20);
		assertEquals(20, user2.getId());
		user3.setId(72);
		assertNotEquals(20, user3.getId());
	}
	
	@Test
	public void testGetId() {
		assertEquals(1, user1.getId());
		assertEquals(20, user2.getId());
		assertEquals(72, user3.getId());
	}
	
	@Test
	public void testGetFirstname() {
		assertEquals("bob", user1.getFirstname());
		assertEquals("noname", user2.getFirstname());
		assertEquals("arthur", user3.getFirstname());
	}
	
	
	@Test
	public void testGetLastname() {
		assertEquals("dylan", user1.getLastname());
		assertEquals("mcgee", user2.getLastname());
		assertEquals("dent", user3.getLastname());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("yes@ycp.edu", user1.getEmail());
		assertEquals("ceo@google.com", user2.getEmail());
		assertEquals("dogsleepingonmyfloor@zackshouse.com", user3.getEmail());
	}
	
	@Test
	public void testSetFirstname() {
		user1.setFirstname("robert");
		assertEquals("robert", user1.getFirstname());
		user2.setFirstname("727");
		assertEquals("727", user2.getFirstname());
		user3.setFirstname("arty");
		assertEquals("arty", user3.getFirstname());
	}
	
	@Test
	public void testSetLastname() {
		user1.setLastname("plant");
		assertEquals("plant", user1.getLastname());
		user2.setLastname("numbers");
		assertEquals("numbers", user2.getLastname());
		user3.setLastname("ply");
		assertEquals("ply", user3.getLastname());
	}
	
	@Test
	public void testSetEmail() {
		user1.setEmail(null);
		assertEquals(null, user1.getEmail());
		user2.setEmail("not a real email");
		assertEquals("not a real email", user2.getEmail());
		user3.setEmail("90degreesinmyroom@help.gov");
		assertEquals("90degreesinmyroom@help.gov", user3.getEmail());
	}
}
