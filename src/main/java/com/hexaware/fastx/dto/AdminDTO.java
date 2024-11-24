package com.hexaware.fastx.dto;

public class AdminDTO {

	private String name;
	private String username;
	private String phone;

	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(String name,String username, String phone) {
		super();
		this.name = name;
		this.phone = phone;
		this.username=username;
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
