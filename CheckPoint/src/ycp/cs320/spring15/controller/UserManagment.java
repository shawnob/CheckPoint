package ycp.cs320.spring15.controller;

import java.util.List;

import ycp.cs320.spring15.model.User;

public class UserManagment {
	
	/*
	 * checks if accessor    has admin privileges, creates new User if there are none with uName as a username, false if failed, true if succeeded
	 */
	boolean addUser (String uName, String pWord, User accessor){
		//TODO Implement
		return false;
	}
	/*
	 * checks if accessor is admin, or the same user that will be deleted (same username). 
	 * returns true if success, false if failed
	 */
	boolean deleteUser(String uName, User accessor){
		//TODO Implement
		return false;
	}
	/*
	 *checks if accessor is admin, or same user whose password is being changed. 
	 *returns true if success, or false if failed. 
	 */
	boolean changePassword (String uName, String pWord, User accessor) {
		//TODO Implement
		return false;
	}
	/*
	 * checks if accessor is admin. if so, return user list, otherwise return null
	 */
	List getUserList (User accessor){
		//TODO Implement
		return null;
	}
	/*
	 * checks if a user is an admin, using AdminList
	 */
	boolean isAdmin(User user) {
		//TODO Implement
		return false;
	}
	/*
	 * get a list of all the courses a user is a student in
	 */
	List getStudentCourselist(String username){
		//TODO
		return null;
	}
	/*
	 * get a list of all the courses a user is a teacher in
	 */
	List getTeacherCourselist(String username){
		//TODO Implement
		return null;
	}
}
