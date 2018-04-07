package com.gof.voting.model;

/**
 * This Class is utility bean for transferring.
 * 
 * @author suraj singh
 *
 */
public class LoginDetails {

	private String userName;

	private String fname;

	private String lname;

	private String password;
	
	private String role;
	
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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
		builder.append("LoginDetails [userName=").append(userName)
				.append(", fname=").append(fname).append(", lname=")
				.append(lname).append(", password=").append(password)
				.append(", role=").append(role).append(", email=")
				.append(email).append("]");
		return builder.toString();
	}
}
