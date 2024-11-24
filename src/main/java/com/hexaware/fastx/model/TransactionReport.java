package com.hexaware.fastx.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "report")
public class TransactionReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private Long reportId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "booking_id")
	private Bookings booking;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payments payment;
	
	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;
	
	@Column(name = "report_date")
	private Date reportDate;

	public TransactionReport(Date reportDate) {
		super();
		this.reportDate = reportDate;
	}

	public TransactionReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@Override
	public String toString() {
		return "TransactionReport [reportId=" + reportId + ", user=" + user + ", booking=" + booking + ", payment="
				+ payment + ", bus=" + bus + ", reportDate=" + reportDate + "]";
	}
	
	
	
}
