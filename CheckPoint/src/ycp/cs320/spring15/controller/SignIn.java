package ycp.cs320.spring15.controller;

import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.model.UserList;

/*
 * SignIn will be called from the controller class to check if a user credentials are valid
 */
public class SignIn {
	
	private UserList userList;
	
	public SignIn (UserList ul)
	{
		userList = ul;
	}

	/* returns null if none    match
	 * returns  a user object with the specified username and password
	 */
	 public User signIn (String uName, String pWord){
		//Check if user exists
		if (userList.containsUser(uName)) {
			//check if passwords match
			if(userList.getUser(uName).getPassword() == pWord){
				//if so return that user
				return userList.getUser(uName);
			
			}
		}
		return null;
	}
	/* 
	 * creates a user object with the specified username and password in the UserList.
	 *  Returns the new User object, or null if failed.
	 */
	User createAccount (String uName, String pWord){
		//Check is user exists
		if(!userList.containsUser(uName)){
			//if not add
			userList.addUser(new User(uName, pWord));
			//return that user
			return userList.getUser(uName);
		}
		return null;
	}
}
