package com.hexaware.fastx.dto;

public class BusOperatorDTO {

	private String operatorName;
	private int age;
	private String username;
	private String phone;
	private Long busId;

	public BusOperatorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusOperatorDTO(String operatorName, int age, String username, String phone, Long busId) {
		super();
		this.operatorName = operatorName;
		this.age = age;
		this.username=username;
		this.phone = phone;
		this.busId = busId;
	}

	public String getName() {
		return operatorName;
	}

	public void setName(String operatorName) {
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
	

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "BusOperatorDTO [name=" + operatorName + ", age=" + age + ", username=" + username + ", phone=" + phone
				+ ", busId=" + busId + "]";
	}

	

}
