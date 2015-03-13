package ycp.cs320.spring15.model;

import java.util.*;



public class CourseList {
	ArrayList<Course> CourseList2;
	
	public CourseList(){
		ArrayList<Course> CourseList2 = new ArrayList<Course>();
		
	}
	public Course getCourse(String coursename){
		Course temp;
		
		for (int c = 0; c < CourseList2.size(); c++){
			temp = CourseList2.get(c);
			System.out.println(temp.courseName);
			
			if (temp.courseName == coursename){
				return temp;
			}
		}
		System.out.println("dead");
		return null;
		
	}
	
	public boolean createCourse(String coursename, String teacher){
		
		
		for (int c = 0; c < CourseList2.size(); c++){
			if (CourseList2.get(c).courseName == coursename){ 
				if (CourseList2.get(c).TeacherList.contains(teacher))
				return false;
			}
		}
		
		Course temp = new Course(null);
			
		temp.courseName = coursename;
		System.out.println(temp.courseName);         //adding teacher doesn't work
		
		//temp.StudentList.indexOf(temp.StudentList.size()+1).add(teacher);
		System.out.println("hi2");
		CourseList2.add(temp);
		
		
		return true;
	}
	
	public void deleteCourse(String coursename){
		for (int c = 0; c < CourseList2.size(); c++){
			if (CourseList2.get(c).courseName == coursename){
				CourseList2.remove(c);
			}
		}
		
			
		
	}
	
	public ArrayList<Course> getCourseList(){
		return CourseList2;
	}
	
}
