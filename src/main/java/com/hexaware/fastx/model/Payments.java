package com.hexaware.fastx.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
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
@Table(name = "payments")
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long paymentId;
	
	@OneToOne
	@JoinColumn(name = "booking_id")
	private Bookings booking;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
	private TransactionReport transactionReport;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "status")
	private String paymentStatus;

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payments(Date paymentDate, int amount, String paymentStatus) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public TransactionReport getTransactionReport() {
		return transactionReport;
	}

	public void setTransactionReport(TransactionReport transactionReport) {
		this.transactionReport = transactionReport;
	}

	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", booking=" + booking + ", user=" + user + ", paymentDate="
				+ paymentDate + ", amount=" + amount + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	
	
}
