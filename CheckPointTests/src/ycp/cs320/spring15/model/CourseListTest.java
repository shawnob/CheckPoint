package ycp.cs320.spring15.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CourseListTest {
	/*
	private CourseList CourseListtest1;
	private ArrayList<Course> CourseListarraytest1 = new ArrayList<Course>();
	
	private Course course1;
	private Course course2;
	private ArrayList<String> StudentListtest1 = new ArrayList<String>();
	private ArrayList<String> TeacherListtest1 = new ArrayList<String>();
	
	@Before
	public void setUp() {
		
		StudentListtest1.add("brad");
		TeacherListtest1.add("bob");
		
		course2 = new Course(null);
		course2.courseName = "science";
		
		course1 = new Course(null);
		course1.courseName = "math";
		course1.StudentList = StudentListtest1;
		course1.TeacherList = TeacherListtest1;
		
		
		CourseListarraytest1.add(course1);
		CourseListtest1 = new CourseList();
		CourseListtest1.CourseList2 = CourseListarraytest1;
		
		
		
	}
	
	
	
	@Test
	public void testcreateCourse() {    
		
		assertEquals(false, CourseListtest1.createCourse("math", "bob"));
		assertEquals(true, CourseListtest1.createCourse("math", "fred"));
		
		CourseListtest1.createCourse("science", "ed");           
		assertEquals(course2.courseName, CourseListtest1.getCourse("science").courseName);
		
	}
	
	@Test
	public void testgetCourseList() {  
		
		assertEquals(CourseListarraytest1, CourseListtest1.getCourseList());
		
	}

	
	
	@Test
	public void testgetCourse() {    
		
		assertEquals(course1, CourseListtest1.getCourse("math"));
		
	}
	
	@Test
	public void testdeleteCourse() {    
		
		CourseListtest1.deleteCourse("math");
		assertNotEquals(course1, CourseListtest1.getCourse("math"));
		
	}
	
	


	*/
}
