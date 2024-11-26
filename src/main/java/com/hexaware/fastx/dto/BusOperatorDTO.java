package com.hexaware.fastx.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class BusOperatorDTO {

	@NotEmpty(message = "Operator name must not be empty")
	private String operatorName;
	@Min(value = 22, message = "Operator age must be greater than 22")
	@Max(value = 50, message = "Operator age must be less than 50")
	private int age;
	@NotEmpty(message = "Username must not be empty")
	private String username;
	@NotEmpty(message = "Phone number must not be empty")
	private String phone;

	public BusOperatorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusOperatorDTO(String operatorName, int age, String username, String phone) {
		super();
		this.operatorName = operatorName;
		this.age = age;
		this.username = username;
		this.phone = phone;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
		return "BusOperatorDTO [operatorName=" + operatorName + ", age=" + age + ", username=" + username + ", phone="
				+ phone + "]";
	}

}
