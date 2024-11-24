package com.hexaware.fastx.dto;

import com.hexaware.fastx.model.LoginDetails.Role;

public class LoginDetailsDTO {

	private String username;
	private Role role;
	
	public LoginDetailsDTO(String username, Role role) {
		super();
		this.username = username;
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

	@Override
	public String toString() {
		return "LoginDetailsDTO [username=" + username + ", role=" + role + "]";
	}
	
	
	
}
