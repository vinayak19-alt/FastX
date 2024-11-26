package com.hexaware.fastx.dto;

import java.util.Date;

import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Payments;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;

public class RefundDTO {

	private Long refundId;
	private Long paymentId;
	
	private Long bookingId;
	private Date refundDate;
	@Min(value = 1, message = "The refund amount must not be less than 1")
	private int refundAmount;
	private String refundStatus;

	public RefundDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RefundDTO(Long refundId, Long paymentId, Long bookingId, Date refundDate, int refundAmount,
			String refundStatus) {
		super();
		this.refundId = refundId;
		this.paymentId = paymentId;
		this.bookingId = bookingId;
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

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
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
		return "RefundDTO [refundId=" + refundId + ", paymentId=" + paymentId + ", bookingId=" + bookingId
				+ ", refundDate=" + refundDate + ", refundAmount=" + refundAmount + ", refundStatus=" + refundStatus
				+ "]";
	}

	
}
