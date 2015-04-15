package ycp.cs320.spring15.webapp.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ycp.cs320.spring15.persist.DatabaseProvider;
import ycp.cs320.spring15.persist.DerbyDatabase;
import ycp.cs320.spring15.persist.FakeDatabase;
import ycp.cs320.spring15.persist.IDatabase;

public class DatabaseInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		// Provide access to a database
		System.out.println("DatabaseInitListener: creating database instance");
		IDatabase db = new FakeDatabase(); // TODO: eventually use a real database implementation -Derby
		DatabaseProvider.setInstance(db);
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// Nothing
	}

}
