package ycp.cs320.spring15.model;

import java.util.*;



public class CourseList {
	ArrayList<Course> CourseList;
	
	public CourseList(){
		ArrayList<Course> CourseList = new ArrayList<Course>();
		
	}
	public Course getCourse(String coursename){
		Course temp;
		
		for (int c = CourseList.size(); c > 0; c--){
			temp = CourseList.get(c);
			if (temp.courseName == coursename){
				return temp;
			}
		}
		
		return null;
		
	}
	
	public boolean createCourse(String coursename, String teacher){
		
		if (CourseList.contains(coursename)){ 
			return false;
		}
		
		Course temp = null;
		temp.courseName = coursename;
		temp.StudentList.add(teacher);
		CourseList.add(temp);
		
		
		return false;
	}
	
	public void deleteCourse(String coursename){
		CourseList.remove(coursename);
			
		
	}
	
	public ArrayList<Course> getCourseList(){
		return CourseList;
	}
	
}
