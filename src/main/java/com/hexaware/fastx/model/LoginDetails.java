package com.hexaware.fastx.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_details")
public class LoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private Long loginId;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(mappedBy = "loginDetails", cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne(mappedBy = "loginDetails", cascade = CascadeType.ALL)
	private BusOperator busOperator;
	
	@OneToOne(mappedBy = "loginDetails", cascade = CascadeType.ALL)
	private Admin admin;
	
	public enum Role{
		User, Operator, Admin
	}

	public LoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDetails(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BusOperator getBusOperator() {
		return busOperator;
	}

	public void setBusOperator(BusOperator busOperator) {
		this.busOperator = busOperator;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "LoginDetails [loginId=" + loginId + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
	
	
}
