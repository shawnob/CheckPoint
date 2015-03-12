package ycp.cs320.spring15.controller;
import ycp.cs320.spring15.model.*;

public class Controller {
	
	private Model model;
	private UserManagement uManager;
	private CourseManagement cManager;
	private User curUser = null;
	
	public Controller (Model inmodel)
	{
		model = inmodel;
		uManager = new UserManagement(model.getUserList());
		cManager = new CourseManagement(model.getCourseList());
	}
	
	public void signIn (String uName, String pWord)
	{
		SignIn login = new SignIn(model.getUserList());
		curUser = login.signIn(uName, pWord);
	}
	
	public void signOut()
	{
		curUser = null;
	}
	
	public User createAccount (String uName, String pWord)
	{
		SignIn createacc = new SignIn(model.getUserList());
		return createacc.createAccount(uName, pWord);
	}
	
	public void userDeleteSelf()
	{
		uManager.deleteUser(curUser.getUsername(), curUser);
		signOut();
	}
	
	public void userChangeOwnPassword(String pWord)
	{
		uManager.changePassword(curUser.getUsername(), pWord, curUser);
	}
	
	
}
