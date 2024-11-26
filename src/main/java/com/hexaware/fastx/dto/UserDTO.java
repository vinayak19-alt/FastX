package com.hexaware.fastx.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class UserDTO {

	@NotEmpty(message = "Name must not be empty")
	private String name;
	@Min(value = 18, message = "Age must be greater than 17")
	private int age;
	private String gender;
	@NotEmpty(message = "Phone number must not be empty")
	private String phone;
	@NotEmpty(message = "username must not be empty")
	private String username;
	@Email(message = "Please enter a valid email id")
	@NotEmpty(message = "Email cannot be null")
	private String email;
	private Long userId;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, int age, String gender, String phone, String username, String email, Long userId) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.username = username;
		this.email = email;
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", username="
				+ username + ", email=" + email + ", userId=" + userId + "]";
	}

	
}
