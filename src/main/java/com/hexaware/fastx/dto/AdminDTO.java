package com.hexaware.fastx.dto;

import jakarta.validation.constraints.NotEmpty;

public class AdminDTO {

	@NotEmpty(message = "name must not be empty")
	private String name;
	@NotEmpty(message = "username must not be empty")
	private String username;
	@NotEmpty(message = "Phone number must not be empty")
	private String phone;

	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(String name, String username, String phone) {
		super();
		this.name = name;
		this.phone = phone;
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AdminDTO [name=" + name + ", username=" + username + ", phone=" + phone + "]";
	}

}
