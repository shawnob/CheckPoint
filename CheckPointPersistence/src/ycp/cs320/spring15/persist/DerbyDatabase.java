package ycp.cs320.spring15.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.Question;
import ycp.cs320.spring15.model.Quiz;
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
	public User findUser(final String username, final String password) {
		return executeTransaction(new Transaction<User>() {
			@Override
			public User execute(Connection conn) throws SQLException {
				System.out.println("findUser: looking for " + username + "/" + password);
				
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select users.* from users " +
							" where users.username = ? and users.password = ?"
					);
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					resultSet = stmt.executeQuery();
					
					if (!resultSet.next()) {
						// no such username/password
						System.out.println("No such user?");
						return null;
					} else {
						User user = new User();
						user.setId(resultSet.getInt(1));
						user.setUsername(resultSet.getString(2));
						user.setPassword(resultSet.getString(3));
						user.setFirstname(resultSet.getString(4));
						user.setLastname(resultSet.getString(5));
						user.setEmail(resultSet.getString(6));
						
						System.out.println("Found user " + user.getUsername() + " with id=" + user.getId());
						
						return user;
					}
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
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
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				
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
							"    id integer not null generated always as identity (start with 1, increment by 1)," +
							"    coursename varchar(120)" +
							")");
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table quiz (" +
							"	id integer not null generated always as identity (start with 1, increment by 1)," +
							"   quizname varchar(80) unique, " +
							"	teacher_id integer," +
							"   course varchar(80)" +
							")");
					stmt3.executeUpdate();
					
					stmt4 = conn.prepareStatement(
							"create table question (" +
							"	id integer not null generated always as identity (start with 1, increment by 1)," +
							"   type integer , " +
							"	question varchar(80)," +
							"   choices varchar(80)," +
							"   correctAnswer integer," +
							"   index varchar(80)," +
							"   quiz_id integer" +
							")");
					stmt4.executeUpdate();
					
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
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

	
	public int retquestnum(int quizID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addQuiz(final String quizName, final User instructor, final String course) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet genKeys = null;
				
				try {
					stmt = conn.prepareStatement(
							"insert into quiz (quizname, teacher_id, course) values (?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
					);
					stmt.setString(1, quizName);
					stmt.setInt(2, instructor.getId());
					stmt.setString(3, course);
					
					stmt.executeUpdate();
					
					genKeys = stmt.getGeneratedKeys();
					if (!genKeys.next()) {
						throw new SQLException("Couldn't get generated id for quiz");
					}
					int quizId = genKeys.getInt(1);
					
					return quizId;
					
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(genKeys);
				}
			}
		});
	}

	@Override
	public Quiz getQuiz(final int ID) {
		return executeTransaction(new Transaction<Quiz>() {
			@Override
			public Quiz execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement("select quiz.* from quiz where quiz.id = ?");
					stmt.setInt(1, ID);
					
					resultSet = stmt.executeQuery();
					if (!resultSet.next()) {
						// No such quiz
						return null;
					}
					
					int id = resultSet.getInt(1);
					String quizName = resultSet.getString(1);
					int teacherId = resultSet.getInt(3);
					String courseName = resultSet.getString(4);
					
					// Find the teacher for this quiz
					User teacher = loadUserForUserId(conn, teacherId);
					
					Quiz result = new Quiz(quizName, teacher, courseName, id);
					
					// Load questions
					loadQuestionsForQuiz(conn, result);
					
					return result;
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}

	protected User loadUserForUserId(Connection conn, int userId) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		try {
			stmt = conn.prepareStatement("select users.* from users where users.id = ?");
			stmt.setInt(1, userId);
			
			resultSet = stmt.executeQuery();
			if (!resultSet.next()) {
				// no such User
				return null;
			}
			
			int id = resultSet.getInt(1);
			String username = resultSet.getString(2);
			String password = resultSet.getString(3);
			String firstname = resultSet.getString(4);
			String lastname = resultSet.getString(5);
			String email = resultSet.getString(6);
			
			User user = new User(username, password, firstname, lastname, email);
			user.setId(id);
			
			return user;
		} finally {
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(resultSet);
		}
	}

	protected void loadQuestionsForQuiz(Connection conn, Quiz quiz) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		try {
			stmt = conn.prepareStatement(
					"select question.* from question where question.quiz_id = ?"
			);
			stmt.setInt(1, quiz.getUniqueID());
			
			resultSet = stmt.executeQuery();
			while (!resultSet.next()) {
				int id = resultSet.getInt(1);
				int type = resultSet.getInt(2);
				String question = resultSet.getString(3);
				String choices = resultSet.getString(4);
				int correctAnswer = resultSet.getInt(5);
				int index = resultSet.getInt(6);
				int quizId = resultSet.getInt(7);
				
				String[] choicesArr = choices.split(",");
				
				Question q = new Question(type, index, question, choicesArr, correctAnswer);
				q.setUniqueID(id);
				q.setQuizId(quizId);
				
				quiz.addQuestion(q);
			}
		} finally {
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(resultSet);
		}
	}

	@Override
	public boolean checkAnswer(int quizID, String FIBanswer, int MCanswer) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

//	@Override
//	public boolean addQuestion(String question, String[] choices,
//			String correctAnswer) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public ArrayList<String> getTeacherCourseList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getStudentCourseList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

//	public Question addQuestion(int type, String question, String[] choices,
//			int correctAnswer) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean isUserTeacher(String username, String coursename) {
		// FIXME: DerbyDatabase makes all users teachers
		return true;
	}

	@Override
	public String[] retquestchoices(int quizID, int questionNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String retquest(int QuizID, int questionnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int retquestnum(int QuizID, int QuestionNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Question addQuestion(final int quizID, final int questionNum, final int type,
			final String question, final String[] choices, final int correctAnswer) {
		return executeTransaction(new Transaction<Question>() {
			@Override
			public Question execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet genKeys = null;
				try {
					stmt = conn.prepareStatement(
							"insert into question (type, question, choices, correctAnswer, index, quiz_id) " +
							" values (?, ?, ?, ?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
					);
					stmt.setInt(1, type);
					stmt.setString(2, question);
					stmt.setString(3, join(choices, ","));
					stmt.setInt(4, correctAnswer);
					stmt.setInt(5,  questionNum);
					stmt.setInt(6, quizID);
					
					stmt.executeUpdate();
					
					genKeys = stmt.getGeneratedKeys();
					if (!genKeys.next()) {
						throw new SQLException("Couldn't get generated id for question");
					}
					int id = genKeys.getInt(1);
					
					Question q = new Question(type, questionNum, question, choices, correctAnswer);
					q.setUniqueID(id);
					
					return q;
					
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(genKeys);
				}
			}
		});

	}

	protected String join(String[] choices, String sep) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < choices.length; i++) {
			if (i > 0) {
				buf.append(sep);
			}
			buf.append(choices[i]);
		}
		return buf.toString();
	}

	@Override
	public void addCourseAssociation(String username, String coursename,
			boolean isTeacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStudentInClass(String username, String coursename) {
		// TODO Auto-generated method stub
		return false;
	}

}
