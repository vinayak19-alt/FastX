package com.hexaware.fastx.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Operator")
public class BusOperator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operator_id")
	private Long operatorId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	private LoginDetails loginDetails;
	
	@OneToMany(mappedBy = "busOperator", cascade = CascadeType.ALL)
	private List<Bus> bus;
	
	@Column(name = "operator_name")
	private String operatorName;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "phonenumber")
	private String phone;

	public BusOperator(String operatorName, int age, String username, String phone) {
		super();
		this.operatorName = operatorName;
		this.age = age;
		this.username=username;
		this.phone = phone;
	}

	public BusOperator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
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
	

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "BusOperator [operatorId=" + operatorId + ", loginDetails=" + loginDetails + ", bus=" + bus
				+ ", operatorName=" + operatorName + ", username=" + username + ", age=" + age + ", phone=" + phone
				+ "]";
	}

	
	
}
