package ycp.cs320.spring15.webapp.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.spring15.model.User;

public class RequireLoginFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// No initialization required
	}

	@Override
	public void doFilter(ServletRequest req_, ServletResponse resp_, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) req_;
		HttpServletResponse resp = (HttpServletResponse) resp_;
		
		System.out.println("RequireLoginFilter");
		
		// See if user is logged in
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("User is not logged in, redirecting to login page");
			// Redirect to login page
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		// Continue with request
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
