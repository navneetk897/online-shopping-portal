package com.shoppingPortal.Model;

public class Session {
	private String sessionId;
	private String userType;
	
	public Session() {
		
	}
	
	public Session(String sessionId, String userType) {
		this.sessionId = sessionId;
		this.userType = userType;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
