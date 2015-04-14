package ycp.cs320.spring15.model;


/*Created by Shawn 0'Brien 3/10
 */

/*The user exists only to store data 
 * this data can then be used to allow/deny certain privileges
 * Usernames will be used to identify individual users.
 * Every username must be unique, and cannot be changed later.
 */





public class User {
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	
	//Set username
	public User(String username, String password, String firstname, String lastname, String email){
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	//Get username
	public String getUsername(){
		return username;
	}
	
	//Get password
	public String getPassword(){
		return password;
	}
	
	//Get Firstname
	public String getFirstname(){
		return firstname;
	}
	
	//Get Lastname
	public String getLastname(){
		return lastname;
	}
	
	//GetEmail
	public String getEmail(){
		return email;
	}
	
	//Allows the password to be changed
	public void setPassword(String newPassword){
		this.password = newPassword;
	}
	
	//Allows email adress to be changed
	public void setEmail(String newEmail){
		this.email = newEmail;
		
	}
	
}
