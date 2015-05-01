package ycp.cs320.spring15.persist;

import java.util.ArrayList;
import java.util.List;

import ycp.cs320.spring15.model.Course;
import ycp.cs320.spring15.model.Question;
import ycp.cs320.spring15.model.Quiz;
import ycp.cs320.spring15.model.User;

public class FakeDatabase implements IDatabase {

	// TODO: fields
	UserList userList = new UserList();
	private List<Course> courseList;
	private int quizUniqueId = 0;
	private int questionUniqueId = 0;
	private List<Quiz> quizList;
	

	public FakeDatabase() {
		// create arraylists
		courseList = new ArrayList<>();

		//Users in database
		userList.addUser(new User("shawn", "obrien", "shawn", "obrien", "shawn@checkpoint.com"));
		userList.addUser(new User("benjamin", "newlin", "benjamin", "newlin", "benn@checkpoint.com"));
		userList.addUser(new User("zackeree", "henry", "zackeree", "henry", "zack@checkpoint.com")); 

		// TODO: fix these
		//		userList.addUser(new User("benjamin", "langsdale", "firstname", "lastname", "benl@checkpoint.com"));
		//		userList.addUser(new User("matthew", "savoca", "firstname", "lastname", "matt@checkpoint.com"));
		userList.addUser(new User("zaphod", "beeblebrox", "firstname", "lastname", "zaphod@checkpoint.com"));
		userList.addUser(new User("marvin", "42", "firstname", "lastname", "marvin@checkpoint.com"));
		userList.addUser(new User("ford", "perfect", "firstname", "lastname", "ford@checkpoint.com"));
		userList.addUser(new User("arthur", "dent", "firstname", "lastname", "arthur@checkpoint.com"));
		userList.addUser(new User("slartibartfast", "42","firstname", "lastname", "slartibartfast@checkpoint.com"));
		userList.addUser(new User("trillian", "42", "firstname", "lastname", "trillian@checkpoint.com"));
		

		//questList1.addQuestion(new Question(0, "quest", null, "ans"));

		//String[] choices = {"Marvin", "no this one", "Maybe this one"};

		quizList = new ArrayList<Quiz>();

		courseList.add(new Course("cs320"));
		
		
		//quizList.add(new Quiz("The Quiz", userList.getUser("marvin") , new Course("cs320") , 666));
		//quizList.get(0).addQuestion(new Question(1, "Whats your name", choices, questionUniqueId));
	}

	/* returns null if none    match
	 * returns  a user object with the specified username and password
	 */
	@Override
	public User findUser(String username, String password) {
		//Check if user exists
		if (userList.containsUser(username)) {
			//check if passwords match
			if(userList.getUser(username).getPassword().equals(password)){
				//if so return that user
				System.out.printf("FindUSer: Passed\n");
				return userList.getUser(username);

			}
		}
		System.out.printf("FindUser: Failed");
		return null;
	}

	@Override
	public Course findCourse(String courseName) {
		for (int i = 0; i < courseList.size(); i++)
		{
			if (courseList.get(i).getCourseName().equals(courseName))
			{
				return courseList.get(i);
			}

		}
		return null;
	}


	/* 
	 * creates a user object with the specified username and password in the UserList.
	 *  Returns the new User object, or null if failed.
	 */
	@Override
	public User createAccount(String username, String password, String firstname, String lastname, String email) {
		//Check is user exists
		if(!userList.containsUser(username) && !userList.containsEmail(email)){
			//if not add
			userList.addUser(new User(username, password, firstname, lastname, email));
			//return that user
			System.out.printf("Account created");
			return userList.getUser(username);
		}
		return null;
	}

	//Search user by email
	@Override
	public User searchUserByEmail(String email) {
		if(userList.containsEmail(email) == true){
			return userList.getUserByEmail(email);
		}
		return null;
	}
	///////////////////////////////
	////////Question Methods///////
	///////////////////////////////
	public Question addQuestion(int type, String question, String[] choices, int correctAnswer){
		Question newQuestion = new Question(type,question,choices,correctAnswer);
		newQuestion.setUniqueID(questionUniqueId);
		questionUniqueId++;
		quizList.get(0).addQuestion(newQuestion);
		return newQuestion;
	}

	//return questionList
	public String retquest(int quizID) {
		/*
		String test = "examplequestion";
		if (quizList.get(quizID).getNumQuestions() > 0){
			return quizList.get(quizID).getQuestion(0).getQuestion();
		}
		return test;
		*/
		Quiz quiz = getQuiz(quizID);
		if (quiz == null) {
			throw new IllegalStateException("No such quiz (id=" + quizID + ")");
		}
		Question q = quiz.getQuestion(0);
		return q.getQuestion();
	}
	
	public int retquestnum(int quizID) {
		int qnum = 1;
		if (quizList.get(quizID).getNumQuestions() > 0){
			return qnum;
		}
		return qnum;
	}
	public boolean checkAnswer(int quizID, String FIBanswer, int MCanswer){
		
			return quizList.get(quizID).getQuestion(0).CheckAnswer(FIBanswer, MCanswer);
	}
	

	@Override
	public void createQuiz(String quizName, User instructor, Course course) {
		
		Quiz newQuiz = new Quiz("quizName", instructor, course, quizUniqueId);
		newQuiz.setUniqueID(quizUniqueId);
		quizList.add(newQuiz);
		quizUniqueId++;
	}

	@Override
	public Question addQuestion(int quizID, int type, String question,
			String[] choices, int correctAnswer) {
		Question newQuestion = new Question(type, question, choices, correctAnswer);
		
		newQuestion.setUniqueID(questionUniqueId);
		questionUniqueId++;
		//quizList.get(quizID).addQuestion(newQuestion);
		
		Quiz quiz = getQuiz(quizID);
		quiz.addQuestion(newQuestion);
		
		return newQuestion;
	}

	@Override
	public int addQuiz(String quizName, User instructor, Course course) {
		Quiz newQuiz = new Quiz(quizName, instructor, course, quizUniqueId);
		quizList.add(newQuiz);
		System.out.printf("Added quiz %s with id=%d\n", newQuiz.getQuizName(), newQuiz.getUniqueID());
		quizUniqueId++;
		return quizUniqueId - 1;
	}
	public Quiz getQuiz(int ID){
		for (Quiz q : quizList) {
			if (q.getUniqueID() == ID) {
				return q;
			}
		}
		return null;
	}
}
