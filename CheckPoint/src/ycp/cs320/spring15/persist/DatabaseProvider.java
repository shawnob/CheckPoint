package ycp.cs320.spring15.persist;

public class DatabaseProvider {
	private static IDatabase theInstance;
	
	public static void setInstance(IDatabase db) {
		theInstance = db;
	}
	
	public static IDatabase getInstance() {
		if (theInstance == null) {
			throw new IllegalStateException("There is no IDatabase!");
		}
		return theInstance;
	}
}
