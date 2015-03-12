package ycp.cs320.spring15.model;

import java.util.*;


public class Course {
	
	String courseName;
	ArrayList<String> StudentList = new ArrayList<String>();
	ArrayList<String> TeacherList = new ArrayList<String>();

	//List Assignment AssignList;
	
	public boolean isOnStudentList(String username){
		if (StudentList.contains(username)){
			return true;
		}
		return false;
	}
	
	public boolean isOnTeacherList(String username){
		if (TeacherList.contains(username)){
			return true;
		}
		return false;
	}
	
	public boolean addStudent(String username){
		
		if (isOnStudentList(username)==true){
			return false;
		}
		
		StudentList.add(username);
		return true;
	}
	
	public boolean addTeacher(String username){
		if (isOnTeacherList(username)){
			return false;
		}
		TeacherList.add(username);
		return true;
	}
	
	public boolean removeTeacher(String username){
		if (TeacherList.size()<=1){
			return false;
		}
		TeacherList.remove(username);
		return true;
	}
	
	public void removeStudent(String username){
		StudentList.remove(username);
	}
	
	//public void removeAllStudents(){
		
	//}
	
	//List getAssignmentList(){
		
	//}
	
	
}

