package org.gp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = -1448684448502193323L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
	
		String username1 =  req.getParameter("username");
		String username = (String) req.getAttribute("userName");
		System.out.println(username + " = " + username1);
		
		String message = (String) req.getAttribute("message");
		resp.getWriter().print(username + " : "+ message);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost");
		doGet(req, resp);
	}
}
