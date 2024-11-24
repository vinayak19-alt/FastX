package com.hexaware.fastx.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id", unique = true, nullable = false)
	private LoginDetails loginDetails;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Payments> payments;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<TransactionReport> transactionReport;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Bookings> booking;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "fullname")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phonenumber")
	private String phone;
	
	@Column(name = "email")
	private String email;

	public User(String name, int age, String gender, String phone, String username, String email) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.username=username;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	
	public List<TransactionReport> getTransactionReport() {
		return transactionReport;
	}

	public void setTransactionReport(List<TransactionReport> transactionReport) {
		this.transactionReport = transactionReport;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginDetails=" + loginDetails + ", payments=" + payments + ", transactionReport="
				+ transactionReport + ", username=" + username + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", phone=" + phone + ", email=" + email + "]";
	}

	

	
	
}
