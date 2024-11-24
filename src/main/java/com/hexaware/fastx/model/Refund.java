package com.hexaware.fastx.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "refund")
public class Refund {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "refund_id")
	private Long refundId;
	
	@OneToOne
	@JoinColumn(name = "booking_id")
	private Bookings booking;
	
	@Column(name = "refund_date")
	private Date refundDate;
	
	@Column(name = "refund_amount")
	private int refundAmount;
	
	@Column(name = "refund_status")
	private String refundStatus;

	public Refund() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Refund(Date refundDate, int refundAmount, String refundStatus) {
		super();
		this.refundDate = refundDate;
		this.refundAmount = refundAmount;
		this.refundStatus = refundStatus;
	}

	public Long getRefundId() {
		return refundId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public int getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	@Override
	public String toString() {
		return "Refund [refundId=" + refundId + ", booking=" + booking + ", refundDate="
				+ refundDate + ", refundAmount=" + refundAmount + ", refundStatus=" + refundStatus + "]";
	}
	
	
	
}
