package ycp.cs320.spring15.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CourseListTest {
	
	private ArrayList<Course> CourseListtest1 = new ArrayList<Course>();
	
	private Course course1;
	private ArrayList<String> StudentListtest1 = new ArrayList<String>();
	private ArrayList<String> TeacherListtest1 = new ArrayList<String>();
	
	@Before
	public void setUp() {
		
		StudentListtest1.add("brad");
		TeacherListtest1.add("bob");
		
		course1 = new Course();
		course1.courseName = "math";
		course1.StudentList = StudentListtest1;
		course1.TeacherList = TeacherListtest1;
		
		CourseListtest1.add(course1);
		
		
	}
	
	

	
	
	@Test
	public void testgetCourse() {    //change name
		//Course temp = CourseListtest1.getCourse("math");
		
		//assertEquals(course1, CourseListtest1.getCourse("math"));
		
	}
	
//	@Test
//	public void testdeleteCourse() {    //change name
//		
//		CourseListtest1.deleteCourse("math");
//		
//	}

}
