package com.hexaware.fastx.dto;

import java.util.List;

public class UserDTO {

	private String name;
	private int age;
	private String gender;
	private String phone;
	private String username;
	private String email;
	private List<Long> paymentIds;
	private Long reportId;
	private Long userId;
	

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserDTO(String name, int age, String gender, String phone,String username, String email, List<Long> paymentIds,
			Long reportId, Long userId) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.username = username;
		this.email = email;
		this.paymentIds = paymentIds;
		this.reportId = reportId;
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


	public List<Long> getPaymentIds() {
		return paymentIds;
	}


	public void setPaymentIds(List<Long> paymentIds) {
		this.paymentIds = paymentIds;
	}


	public Long getReportId() {
		return reportId;
	}


	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	
	


	public Long getUserId() {
		return userId;
	}


	public void setLoginId(Long userId) {
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
				+ username + ", email=" + email + ", paymentIds=" + paymentIds + ", reportId=" + reportId + ", userId="
				+ userId + "]";
	}


	
	

}
