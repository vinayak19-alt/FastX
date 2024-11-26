package com.hexaware.fastx.dto;

import java.util.Date;

import com.hexaware.fastx.model.Refund;
import com.hexaware.fastx.model.TransactionReport;
import com.hexaware.fastx.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;

public class PaymentsDTO {

	private Long paymentId;
	private Long bookingId;
	private Long userId;
	
	private Long refundId;
	
	private Long transactionReportId;
	private Date paymentDate;
	@Min(value = 0, message = "Payment amount must not be 0 or less than 0")
	private int amount;
	private String paymentStatus;

	public PaymentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentsDTO(Long paymentId, Long bookingId, Long userId, Long refundId, Long transactionReportId,
			Date paymentDate, int amount, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.userId = userId;
		this.refundId = refundId;
		this.transactionReportId = transactionReportId;
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

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRefundId() {
		return refundId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Long getTransactionReportId() {
		return transactionReportId;
	}

	public void setTransactionReportId(Long transactionReportId) {
		this.transactionReportId = transactionReportId;
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

	@Override
	public String toString() {
		return "PaymentsDTO [paymentId=" + paymentId + ", bookingId=" + bookingId + ", userId=" + userId + ", refundId="
				+ refundId + ", transactionReportId=" + transactionReportId + ", paymentDate=" + paymentDate
				+ ", amount=" + amount + ", paymentStatus=" + paymentStatus + "]";
	}

	

}
