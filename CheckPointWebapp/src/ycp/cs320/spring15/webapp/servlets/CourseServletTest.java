package ycp.cs320.spring15.webapp.servlets;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.*;

public class CourseServletTest {
	Controller controller;
	CourseServlet csTest;
	HttpServletRequest req;
	HttpServletResponse resp;
	
	@Before
	public void setUp() {
		controller = new Controller();
		csTest = new CourseServlet();
	}
	
	@Test
	public void testDoGet() {
		assertEquals(null, csTest.doGet(req, resp));
	}
}
