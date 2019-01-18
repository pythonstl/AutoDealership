package com.app.admin.model;

public class Administrator {
	private String username, password;
	private boolean isLoggedIn;
	
	///!!!
	private String sampleUsername = "jon.snow";
	private String samplePassword = "password1";
	///!!!
	
	// new administrator for this.session
	public Administrator() {
		this.username = sampleUsername;
		this.password = samplePassword;
		this.isLoggedIn = false;
	}
	
	public String getUsername() {
		return username;
	}
	/*public void setUsername(String username) {
		this.username = username;
	}*/
	public String getPassword() {
		return password;
	}
	/*public void setPassword(String password) {
		this.password = password;
	}*/
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
}
