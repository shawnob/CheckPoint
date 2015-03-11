package ycp.cs320.spring15.model;

import java.util.ArrayList;

/*Created by Shawn O'Brien 3/10/15
 * 
 */

/*Contains array list of all users
 * Methods for managing the users
 */

public class UserList {

	private ArrayList<User> userList;
	
	
	
	//Contains boolean contains  
	public boolean containsUser(String username){
		if (userList.contains(username) == true){
			return true;
		}else {
			return false;
		}
	}
	
	
	
	//returns a user object with the given username
	public User getUser(String username){
		int index = userList.indexOf(username);
		return userList.get(index);
	}
	
	
	
	/*creates a new User object in the list with given username and password. 
	 *here cannot be any repeat usernames.  Returns true if user creation successful, 
	 * false if user creation failed
	 */
	boolean CreateUser(String username, String password){
		//Use containseUser to check to see if user already exists. 
		if (containsUser(username) == false){
			userList.add(new User(username, password));
			return true;
		}else{
			return false;
		}
		
		
	}
	
	public void addUser(User newUser){
		userList.add(newUser);
	}
	
	//removes the given user from users
	public void deleteUser(User user){
		userList.remove(user);
	}
	
	//returns Users
	public ArrayList getUserList(){
		return userList;
	}
	
	
		
}
