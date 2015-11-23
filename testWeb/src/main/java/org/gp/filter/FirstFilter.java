package org.gp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter{

	private static final String[] USERNAME_DIRTY_STRING = {"chen","guang","ping"};
	private static final String[] MESSAGE_DIRTY_STRING = {"fuck","shit"};
	
	@Override
	public void destroy() {
		System.out.println("destroy invoke...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		String userName = req.getParameter("username");
		String message = req.getParameter("message");
		if(null == userName){
			chain.doFilter(req, resp);
			return;
		}
		
		for(String userNameStr : USERNAME_DIRTY_STRING){
			if(userName.toLowerCase().contains(userNameStr)){
				userName = userName.replace(userNameStr, generateStar(userNameStr));
			}
		}
		for(String messageStr : MESSAGE_DIRTY_STRING){
			if(message.toLowerCase().contains(messageStr)){
				message = message.replace(messageStr, generateStar(messageStr));
			}
		}
		req.setAttribute("userName", userName);
		req.setAttribute("message", message);
		chain.doFilter(req, resp);
	}
	
	private String generateStar(String str){
		StringBuffer sb = new StringBuffer();
		int length = str.length();
		while(length -- > 0){
			sb.append("*");
		}
		return sb.toString();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init invoke...");
	}

}
