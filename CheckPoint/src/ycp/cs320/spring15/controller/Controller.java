package ycp.cs320.spring15.controller;
import ycp.cs320.spring15.model.*;

public class Controller {
	
	Model model;
	
	public Controller (Model inmodel)
	{
		model = inmodel;
	}
	
	public User signIn (String uName, String pWord)
	{
		SignIn login = new SignIn(model.getUserList());
		return login.signIn(uName, pWord);
	}
	
}
