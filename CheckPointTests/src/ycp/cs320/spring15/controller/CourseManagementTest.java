package ycp.cs320.spring15.controller;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import ycp.cs320.spring15.model.*;

public class CourseManagementTest {
	private Course course1;
	private Course course2;
	private Course course3;
	
	private CourseList list;
	
	private CourseManagement CM;
	
	@Before
	public void setUp() {
		course1 = new Course("Calculus 3");
		course2 = new Course("Chemistry");
		course3 = new Course("CS320");
		
		list = new CourseList();
		
		CM = new CourseManagement(list);
	}
}
