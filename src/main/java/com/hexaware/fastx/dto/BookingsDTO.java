package com.hexaware.fastx.dto;

import java.sql.Date;

import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.Payments;
import com.hexaware.fastx.model.Refund;
import com.hexaware.fastx.model.Route;
import com.hexaware.fastx.model.TransactionReport;
import com.hexaware.fastx.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class BookingsDTO {

	private Long bookingId;
	private Long userId;
	private int amount;
	@Min(value = 1, message = "Please book atleast 1 ticket to move further")
	private int ticketsBooked;
	private Date date;
	@NotEmpty(message = "The bus number must not be empty")
	private String busNumber;
	private String status;

	public BookingsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingsDTO(Long bookingId, Long userID, int amount, String busNumber, int ticketsBooked, Date date, String status) {
		super();
		this.bookingId = bookingId;
		this.userId=userID;
		this.amount = amount;
		this.ticketsBooked=ticketsBooked;
		this.date = date;
		this.busNumber = busNumber;
		this.status =status;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BookingsDTO [bookingId=" + bookingId + ", userId=" + userId + ", amount=" + amount + ", ticketsBooked="
				+ ticketsBooked + ", date=" + date + ", busNumber=" + busNumber + ", status=" + status + "]";
	}

	
}
