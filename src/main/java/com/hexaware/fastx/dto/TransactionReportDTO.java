package com.hexaware.fastx.dto;

import java.util.Date;

import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.Payments;
import com.hexaware.fastx.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class TransactionReportDTO {

	private Long reportId;

	private Date reportDate;

	@NotEmpty(message = "username must not be empty")
	private String username;
	@Min(value = 1, message = "Please book atleast 1 ticket to move further")
	private int ticketsBooked;
	private String busNumber;
	private int amount;
	private String departDate;
	private String departTime;
	private String arrTime;

	public TransactionReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionReportDTO(Long reportId, Date reportDate, String username, int ticketsBooked, String busNumber,
			int amount, String departDate, String departTime, String arrTime) {
		super();
		this.reportId = reportId;
		this.reportDate = reportDate;
		this.username = username;
		this.ticketsBooked = ticketsBooked;
		this.busNumber = busNumber;
		this.amount = amount;
		this.departDate = departDate;
		this.departTime = departTime;
		this.arrTime = arrTime;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTicketsBooked() {
		return ticketsBooked;
	}

	public void setTicketsBooked(int ticketsBooked) {
		this.ticketsBooked = ticketsBooked;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	@Override
	public String toString() {
		return "TransactionReportDTO [reportId=" + reportId + ", reportDate=" + reportDate + ", username=" + username
				+ ", ticketsBooked=" + ticketsBooked + ", busNumber=" + busNumber + ", amount=" + amount
				+ ", departDate=" + departDate + ", departTime=" + departTime + ", arrTime=" + arrTime + "]";
	}
	
	
}
