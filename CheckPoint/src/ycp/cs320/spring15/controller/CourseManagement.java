package ycp.cs320.spring15.controller;

import java.util.List;

import ycp.cs320.spring15.model.User;

/*
 * Allows teachers to modify their courses, or admins to modify any course
 */
public class CourseManagement {

	
	/*
	 * Creates new course if there are none with courseName as a course name, false if failed, true if succeeded
	 */
	boolean addCourse (String courseName, User accessor){
		//TODO: Implement
		return false;
	}
	/*
	 *Checks if accessor is admin, or a teacher in that course. if so, deletes course. returns true if success, false if failed
	 */
	boolean deleteCourse(String uName, User accessor){
		//TODO: Implement
		return false;
	}
	/*
	 *Checks if accessor is admin, or a teacher in the course. Adds uName to course’s student list. True if successful, false if failed
	 */
	boolean addStudent (String uName, User accessor){
		//TODO: Implement
		return false;
	}
	/*
	 * Checks if accessor is admin, or a teacher in the course. Adds uName to course’s teacher list. True if successful, false if failed
	 */
	boolean addTeacher (String uName, User accessor){
		//TODO:
		return false;
	}
	/*
	 *checks if accessor is admin. if so, return full course list, otherwise return null 
	 */
	List getCourseList (User accessor){
		//TODO: Implement
		return null;
	}

}
