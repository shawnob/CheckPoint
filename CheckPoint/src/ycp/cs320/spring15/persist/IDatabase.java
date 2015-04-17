package ycp.cs320.spring15.persist;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.User;

public interface IDatabase {
	
	//Decelerations call methods in FakeDatabase
	public User findUser(String username, String password);
	public Course findCourse(String courseName);
	public User createAccount(String username, String password, String firstname, String lastname, String email);
	public User searchUserByEmail(String email);
	
	
}