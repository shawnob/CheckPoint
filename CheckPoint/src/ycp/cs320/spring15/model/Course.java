package ycp.cs320.spring15.model;

import java.util.*;


public class Course {
	private int id;
	String courseName;
//	ArrayList<String> StudentList;
//	ArrayList<String> TeacherList;
//	ArrayList<Assignment> AssignList;
	
	public Course(String courseName){
		this.courseName = courseName;
//		StudentList = new ArrayList<String>();
//		TeacherList = new ArrayList<String>();
		//TeacherList.add(Teacher);
	}
	
	public String getCourseName ()
	{
		return courseName;
	}
	
//	public boolean isOnStudentList(String username){
//		if (StudentList.contains(username)){
//			return true;
//		}
//		StudentList.add(username);
//		return false;
//	}
//	
//	public boolean isOnTeacherList(String username){
//		if (TeacherList.contains(username)){
//			return true;
//		}
//		TeacherList.add(username);
//		return false;
//	}
//	
//	public boolean addStudent(String username){
//		
//		if (isOnStudentList(username)==true){
//			return false;
//		}
//		
//		StudentList.add(username);
//		return true;
//	}
//	
//	public boolean addTeacher(String username){
//		if (isOnTeacherList(username)){
//			return false;
//		}
//		TeacherList.add(username);
//		return true;
//	}
//	
//	public boolean removeTeacher(String username){
//		if (TeacherList.size()<=1){
//			return false;
//		}
//		TeacherList.remove(username);
//		return true;
//	}
//	
//	public void removeStudent(String username){
//		StudentList.remove(username);
//	}
//	
//	public void removeAllStudents(){
//		for(int i = 0; i < StudentList.size(); i++){
//		StudentList.remove(i);
//		}
//	}
//	
//	public ArrayList<Assignment> getAssignmentList(){
//		return this.AssignList;	
//	}
	
	
}

