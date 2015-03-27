package ycp.cs320.spring15.persist;

import java.util.ArrayList;
import java.util.List;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.model.UserList;

public class FakeDatabase implements IDatabase {
	
	// TODO: fields
	private UserList userList = new UserList();
	private List<Course> courseList;
	
	public FakeDatabase() {
		// create arraylists
		courseList = new ArrayList<>();
		
		//Users in database
		userList.addUser(new User("shawn", "obrien", "shawn", "obrien", "shawn@checkpoint.com"));
		userList.addUser(new User("benjamin", "newlin", "benjamin", "newlin", "benn@chekpoint.com"));
		userList.addUser(new User("benjamin", "langsdale", "firstname", "lastname", "benl@checkpoint.com"));
		userList.addUser(new User("matthew", "savoca", "firstname", "lastname", "matt@checkpoint.com"));
		userList.addUser(new User("zackeree", "henry", "firstname", "lastname", "zack@checkpoint.com"));
		userList.addUser(new User("zaphod", "beeblebrox", "firstname", "lastname", "zaphod@checkpoint.com"));
		userList.addUser(new User("marvin", "42", "firstname", "lastname", "marvin@checkpoint.com"));
		userList.addUser(new User("ford", "perfect", "firstname", "lastname", "ford@checkpoint.com"));
		userList.addUser(new User("arthur", "dent", "firstname", "lastname", "arthur@checkpoint.com"));
		userList.addUser(new User("slartibartfast", "42","firstname", "lastname", "slartibartfast@checkpoint.com"));
		userList.addUser(new User("trillian", "42", "firstname", "lastname", "trillian@checkpoint.com"));
	}

	/* returns null if none    match
	 * returns  a user object with the specified username and password
	 */
	@Override
	public User findUser(String username, String password) {
		//Check if user exists
		if (userList.containsUser(username)) {
			//check if passwords match
			if(userList.getUser(username).getPassword().equals(password)){
				//if so return that user
				System.out.printf("FindUSer: Passed\n");
				return userList.getUser(username);
			
			}
		}
		System.out.printf("FindUser: Failed");
		return null;
	}

	@Override
	public Course findCourse(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/* 
	 * creates a user object with the specified username and password in the UserList.
	 *  Returns the new User object, or null if failed.
	 */
	@Override
	public User createAccount(String username, String password, String firstname, String lastname, String email) {
		//Check is user exists
				if(!userList.containsUser(username) && !userList.containsEmail(email)){
					//if not add
					userList.addUser(new User(username, password, firstname, lastname, email));
					//return that user
					System.out.printf("Account created");
					return userList.getUser(username);
				}
		return null;
	}

	@Override
	public User searchUserByEmail(String email) {
		if(userList.containsEmail(email) == true){
			return userList.getUserByEmail(email);
		}
		return null;
	}
	

}
