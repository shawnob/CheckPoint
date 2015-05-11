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
	private ArrayList<CourseAssociation> userCourses;
	private int questionListUniqueId = 0;

	public FakeDatabase() {
		// create arraylists
		courseList = new ArrayList<>();
		userCourses = new ArrayList<CourseAssociation>();
		
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

		String[] choices = {"Marvin", "no this one", "Maybe this one"};

		quizList = new ArrayList<Quiz>();

		courseList.add(new Course("cs320"));

		
		
		quizList.add(new Quiz("The Quiz", userList.getUser("marvin") , new Course("cs320") , 666));
		
		//short answer questions
		this.getQuiz(666).addQuestion(new Question(0,0, "Whats your name", null, 5));
		this.getQuiz(666).addQuestion(new Question(0,0, "Whats", null, 6));
		
		//multiple cloice questions
//		this.getQuiz(666).addQuestion(new Question(1,0, "Whats your name", choices, 0));
//		this.getQuiz(666).addQuestion(new Question(1,1, "n2", choices, 1));
//		this.getQuiz(666).addQuestion(new Question(1,2, "n3", choices, 2));

		courseList.add(new Course("Truffles 101"));
		courseList.add(new Course("The-Spells-of-Starswirl-the-Bearded"));
		courseList.add(new Course("Intro-to-Statistics-In-Improbability-Space"));
		courseList.add(new Course("Life-the-Universe-and-Everything-242"));
		
		userCourses.add(new CourseAssociation("cs320", "zaphod", true));
		userCourses.add(new CourseAssociation("Intro-to-Statistics-In-Improbability-Space", "zaphod", false));
		userCourses.add(new CourseAssociation("Life-the-Universe-and-Everything-242", "zaphod", false));

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
	
	public ArrayList <String> getTeacherCourseList(String username)
	{
		ArrayList<String> clist = new ArrayList<String>();
		for (int i = 0; i < userCourses.size(); i++)
		{
			String b = userCourses.get(i).getCoursenameWithConditions(username, true);
			
			if(b != null)
			{
				clist.add(b);
			}
		}
		return clist;
	}
	
	public ArrayList <String> getStudentCourseList(String username)
	{
		ArrayList<String> clist = new ArrayList<String>();
		for (int i = 0; i < userCourses.size(); i++)
		{
			String b = userCourses.get(i).getCoursenameWithConditions(username, false);
			
			if(b != null)
			{
				clist.add(b);
			}
		}
		return clist;
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
	public Question addQuestion(int quizID,int type,int questionNum, String question, String[] choices, int correctAnswer){
		Question newQuestion = new Question(type,questionNum,question,choices,correctAnswer);
		newQuestion.setUniqueID(questionUniqueId);
		questionUniqueId++;
		this.getQuiz(quizID).addQuestion(newQuestion);
		return newQuestion;
	}
	
	//return questionList
	public String retquest(int quizID, int questionnum) {
		Quiz quiz = getQuiz(quizID);
		if (quiz == null) {
			throw new IllegalStateException("No such quiz (id=" + quizID + ")");
		}
		Question q = quiz.getQuestion(questionnum);
		return q.getQuestion();
	}

	public boolean checkAnswer(int quizID,int questionNum, String FIBanswer, int MCanswer){
		
			return this.getQuiz(quizID).getQuestion(questionNum).CheckAnswer(FIBanswer, MCanswer);
	}
	
	
	public int retquesttype(int quizID, int questionNum) {
		
		return getQuiz(quizID).getQuestion(questionNum).getQuestionType();
	}
	
	public String[] retquestchoices(int quizID, int questionNum) {
		
		return getQuiz(quizID).getQuestion(questionNum).getChoices();
	}
	
	
	@Override
	public int retquestnum(int QuizID, int QuestionNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Quiz createQuiz(String quizName, User instructor, Course course) {
		
		Quiz newQuiz = new Quiz("quizName", instructor, course, quizUniqueId);
		newQuiz.setUniqueID(quizUniqueId);
		quizList.add(newQuiz);
		quizUniqueId++;
		return newQuiz;
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

	@Override
	public boolean addQuestion(String question, String[] choices,
			String correctAnswer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserTeacher(String username, String coursename) {
		
		ArrayList<String> cList = getTeacherCourseList(username);
		
		for (int i = 0; i < cList.size(); i++)
		{
			if(cList.get(i).equals(coursename))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Question addQuestion(int type, String question, String[] choices,
			int correctAnswer) {
		return null;
	}
//
//	@Override
//	public String retquest() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean checkAnswer(int quizID, String FIBanswer, int MCanswer) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	@Override
//	public int retquestnum() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
