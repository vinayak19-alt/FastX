package com.hexaware.fastx.dto;

import com.hexaware.fastx.model.LoginDetails.Role;

public class LoginDetailsDTO {

	private String username;
	private String password;
	private Role role;
	
	public LoginDetailsDTO(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public LoginDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDetailsDTO [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
}
