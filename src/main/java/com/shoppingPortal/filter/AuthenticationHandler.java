package com.shoppingPortal.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingPortal.DAO.DataBaseService;
import com.shoppingPortal.Model.Session;

public class AuthenticationHandler implements Filter {

	private DataBaseService dataBaseService = new DataBaseService();
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		PrintWriter writer = res.getWriter();
		String sessionId = req.getHeader("sessionId");
		if (sessionId == null) {
			res.setStatus(401);
			writer.println("Session id not provided in header");
			return;
		}
		Session session = dataBaseService.getSession(sessionId);
		if (session != null) {
			chain.doFilter(request, response);
		}
		res.setStatus(409);
		writer.println("Invalid session id");
		
	}

}
