package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		clearSession(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		clearSession(req, resp);
	}

	private void clearSession(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String username = (String) req.getSession().getAttribute("username");
		if (username != null) {
			System.out.println("Logging out user: " + username);
			req.getSession().invalidate();
		}
		
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
