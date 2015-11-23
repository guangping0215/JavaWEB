package org.gp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class ImageSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 7157849839728454147L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			serviceM(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			serviceM(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void serviceM(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String searchText = req.getParameter("name");
		URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q="+searchText+"");
		URLConnection connection = url.openConnection();
		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while((line = reader.readLine()) != null) {
			builder.append(line);
		}
		JSONObject json = new JSONObject(builder.toString());
		resp.setContentType("application/json");
		resp.setHeader("pragma","no-cache");
		resp.setHeader("cache-control","no-cache");
		resp.getWriter().print(json);
		
	}

}
