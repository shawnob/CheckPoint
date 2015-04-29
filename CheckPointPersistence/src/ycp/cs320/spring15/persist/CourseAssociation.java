package ycp.cs320.spring15.persist;

public class CourseAssociation {
	
	private String coursename;
	private String username;
	private boolean isTeacher;
	
	public CourseAssociation(String CourseName, String UserName, boolean isTeach)
	{
		coursename = CourseName;
		username = UserName;
		isTeacher = isTeach;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getCoursename()
	{
		return coursename;
	}
	
	public boolean getIsTeacher()
	{
		return isTeacher;
	}

	public String getCoursenameWithConditions (String UserName, boolean isTeach)
	{
		//returns coursename if username and isteacher match the inputs, returns null otherwise
		if ((!isTeacher && !isTeach) || (isTeacher && isTeach))
		{
			if (UserName.equals(username))
			{
				return coursename;
			}
		}
		return null;
	}
}
