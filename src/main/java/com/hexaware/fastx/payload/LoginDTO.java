package com.hexaware.fastx.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginDTO {

	@NotEmpty(message = "Username cannot be empty")
	private String username;
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 8, max = 12, message = "Password must have a length between 8 and 12")
	private String password;

	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + "]";
	}

}
