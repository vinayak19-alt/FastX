package com.hexaware.fastx.payload;

import jakarta.validation.constraints.NotEmpty;

public class LoginUserDTO {
	
	@NotEmpty(message = "Username cannot be empty for login")
	private String username;
	@NotEmpty(message = "Role cannot be empty")
	private String role;

	public LoginUserDTO(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}

	public LoginUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginUserDTO [username=" + username + ", role=" + role + "]";
	}
	
	

}
