package com.hexaware.fastx.payload;

import com.hexaware.fastx.model.LoginDetails;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterDTO {
	@NotEmpty(message = "username must not be empty")
	private String username;
	@NotEmpty(message = "Password must not be empty")
	@Size(min = 8, max = 12, message = "Password between 8 and 12 in length")
	private String password;
	@NotNull
	private LoginDetails.Role role;

	public RegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterDTO(String username, String password, LoginDetails.Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
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

	public LoginDetails.Role getRole() {
		return role;
	}

	public void setRole(LoginDetails.Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegisterDTO [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	

}
