package com.gof.voting.model;

/**
 * This Class is utility bean for transferring.
 * 
 * @author suraj singh
 *
 */
public class LoginDetails {

	private int userId;

	private String userName;

	private String password;

	private String role;
	
	private String email;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginDetails [userId=").append(userId)
				.append(", userName=").append(userName).append(", password=")
				.append(password).append(", role=").append(role).append("]");
		return builder.toString();
	}

}
