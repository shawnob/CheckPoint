package ycp.cs320.spring15.model;

import java.util.List;

public class Model {
	
	UserList users = new UserList();
	
	public User getUser(String username)
	{
		return users.getUser(username);
	}
	
	public boolean addUser(String uname, String pword)
	{
		return users.CreateUser(uname, pword);
	}
	
	public void deleteUser(User deluser)
	{
		users.deleteUser(deluser);
	}
	
	public void deleteUser(String username)
	{
		User deluser = users.getUser(username);
		users.deleteUser(deluser);
	}
	
	public UserList getUserList()
	{
		return users;
	}
	
	public List<User> getListofUsers()
	{
		return users.getUserList();
	}
	
	
}
