package ycp.cs320.spring15.controller;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import ycp.cs320.spring15.model.*;

public class CourseManagementTest {
	private Course course1; 
	
	private CourseList list;
	
	private CourseManagement CM;
	
	@Before
	public void setUp() {
		course1 = new Course("Calculus 3");
		
		list = new CourseList();
		
		CM = new CourseManagement(list);
	}
	
	@Test
	public void testAddCourse() {
		assertEquals(false, CM.addCourse("", null));
	}
	
	@Test
	public void testAddStudent() {
		assertEquals(false, CM.addStudent("", null));
	}
	
	@Test
	public void testDelCourse() {
		assertEquals(false, CM.deleteCourse("", null));
	}
	
	@Test
	public void testAddTeacher() {
		assertEquals(false, CM.addTeacher("", null));
	}
	
	@Test
	public void testGetCourseList() {
		assertEquals(null, CM.getCourseList(null));
	}
}
