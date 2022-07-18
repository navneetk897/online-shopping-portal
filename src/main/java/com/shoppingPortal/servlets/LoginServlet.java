package com.shoppingPortal.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingPortal.DAO.DataBaseService;
import com.shoppingPortal.Model.Session;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DataBaseService dataBaseService = new DataBaseService();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		String userName = request.getParameter("username");
		BufferedReader reader = request.getReader();
		String password = reader.readLine();
		
		Session session = dataBaseService.getSession(userName, password);
		PrintWriter writer = response.getWriter();
		
		if (session == null) {
			response.setStatus(404);
			writer.println("Invalid username and password");
			return;
		}
		
		response.setStatus(200);
		writer.print(session.getSessionId() + "," + session.getUserType());
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
		String sessionId = request.getParameter("sessionId");
		dataBaseService.deleteSession(sessionId);
	}
}
