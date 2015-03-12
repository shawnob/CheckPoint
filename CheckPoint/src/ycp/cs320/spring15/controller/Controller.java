package ycp.cs320.spring15.controller;
import ycp.cs320.spring15.model.*;

public class Controller {
	
	private Model model;
	private User curUser;
	
	public Controller (Model inmodel)
	{
		model = inmodel;
	}
	
	public void signIn (String uName, String pWord)
	{
		SignIn login = new SignIn(model.getUserList());
		return login.signIn(uName, pWord);
	}
	
	public User createAccount (String uName, String pWord)
	{
		SignIn createacc = new SignIn(model.getUserList());
		return createacc.createAccount(uName, pWord);
	}
	
	public 
	
}
