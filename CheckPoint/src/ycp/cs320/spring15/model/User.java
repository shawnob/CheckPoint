package ycp.cs320.spring15.model;


/*Created by Shawn 0'Brien 3/10
 */

/*The user exists only to store data 
 * this data can then be used to allow/deny certain privileges
 * Usernames will be used to identify individual users.
 * Every username must be unique, and cannot be changed later.
 */





public class User {

	private String username;
	private String password;
	
	
	//Set username
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	//Get username
	public String getUsername(){
		return username;
	}
	
	//Get password
	public String getPassword(){
		return password;
	}
	
	//Allows the password to be changed
	public void setPassword(String newPassword){
		this.password = newPassword;
	}
	
	
}
