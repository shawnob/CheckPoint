package ycp.cs320.spring15.persist;

import ycp.cs320.spring15.model.User;

public interface IDatabase {
	public User findUser(String username, String password);
}
