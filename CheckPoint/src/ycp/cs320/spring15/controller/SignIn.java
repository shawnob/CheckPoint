package ycp.cs320.spring15.controller;

import ycp.cs320.spring15.model.Model;
import ycp.cs320.spring15.model.User;
import ycp.cs320.spring15.model.UserList;

private Controller controller;

/*
 * SignIn will be called from the controller class to check if a user credentials are valid
 */
public class SignIn {
	
	/* returns null if none    match
	 * returns  a user object with the specified username and password
	 */
	 public User signIn (String uName, String pWord){
		//TODO compare uName and Pword to list
		 boolean result = Controller.getUserList().containsUser(uName);
		//if (Controller.getUserList().containsUser(uName)) {
			
		//}
		return null;
	}
	/* 
	 * creates a user object with the specified username and password in the UserList.
	 *  Returns the new User object, or null if failed.
	 */
	User createAccount (String uName, String pWord){
		//TODO:Implement
		return null;
	}
}