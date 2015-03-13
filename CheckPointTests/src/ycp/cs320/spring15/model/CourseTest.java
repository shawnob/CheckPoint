package ycp.cs320.spring15.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {       //init test variables
	private Course course1;
	private ArrayList<String> StudentListtest1 = new ArrayList<String>();
	private ArrayList<String> TeacherListtest1 = new ArrayList<String>();
	
	
	@Before
	public void setUp() {
		StudentListtest1.add("brad");
		TeacherListtest1.add("bob");
		
		course1 = new Course(null);
		course1.courseName = "math";
		course1.StudentList = StudentListtest1;
		course1.TeacherList = TeacherListtest1;
		
	}
	
	
	@Test
	public void testisOnStudentList() {        //test if students are on the list
		assertEquals(true, course1.isOnStudentList("brad"));
		assertEquals(false, course1.isOnStudentList("bob"));
	}
	
	@Test
	public void testaddStudent() {      //test if add student is working
		assertEquals(true, course1.addStudent("sally"));
		assertEquals(false, course1.addStudent("brad"));
	}
	
	@Test
	public void testaddTeacher() {      //test is add teacher is working
		assertEquals(true, course1.addTeacher("fred"));
		assertEquals(false, course1.addTeacher("bob"));
	}
	
	
	
	@Test
	public void testremoveTeacher() {      //test remove teacher
		assertEquals(false, course1.removeTeacher("bob"));
	}
	
	
	@Test
	public void testremoveStudent() {        //test remove student
		course1.removeStudent("brad");
		assertEquals(false, course1.isOnStudentList("brad"));
	}
	
}
