package ycp.cs320.spring15.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.User;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby JDBC driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCourse(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createAccount(final String username, final String password,
			final String firstname, final String lastname, final String email) {
		return executeTransaction(new Transaction<User>() {
			@Override
			public User execute(Connection conn) throws SQLException {
				User u = new User(username, password, firstname, lastname, email);
				insertUser(conn, u);
				return u;
			}
		});
	}

	@Override
	public User searchUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		String home = System.getProperty("user.home");
		Connection conn = DriverManager.getConnection("jdbc:derby:" + home + "/checkpoint.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}

	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				
				try {
					stmt1 = conn.prepareStatement(
							"create table users (" +
							"    id integer not null generated always as identity (start with 1, increment by 1)," +
							"    username varchar(80) unique, " +
							"    password varchar(80), " +
							"    firstname varchar(50), " +
							"    lastname varchar(80), " +
							"    email varchar(120) " +
							")");
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"create table courses (" +
							"    id integer primary key," +
							"    coursename varchar(120)" +
							")");
					stmt2.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				// Get the initial user accounts from FakeDatabase
				FakeDatabase f = new FakeDatabase();
				
				for (User u : f.userList.getUserList()) {
					insertUser(conn, u);
				}
				
				return true;
			}
		});
		
	}
	
	protected void insertUser(Connection conn, User u) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"insert into users " +
					"  (username, password, firstname, lastname, email) " +
					"  values (?, ?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS
			);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getFirstname());
			stmt.setString(4, u.getLastname());
			stmt.setString(5, u.getEmail());
			
			stmt.executeUpdate();
			
			ResultSet genKeys = stmt.getGeneratedKeys();
			genKeys.next();
			u.setId(genKeys.getInt(1));
		} finally {
			DBUtil.closeQuietly(stmt);
		}
	}

	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}
}
