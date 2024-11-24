package com.hexaware.fastx.model;

import org.springframework.web.jsf.FacesContextUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long adminId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	private LoginDetails loginDetails;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "phonenumber")
	private String phone;
	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String username, String phone) {
		super();
		this.name = name;
		this.phone = phone;
		this.username=username;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
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
		return "Admin [adminId=" + adminId + ", loginDetails=" + loginDetails + ", name=" + name + ", username="
				+ username + ", phone=" + phone + "]";
	}
	
}
