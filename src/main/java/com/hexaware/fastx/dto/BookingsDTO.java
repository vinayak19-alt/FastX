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
	private int amount;
	@Min(value = 1, message = "Please book atleast 1 ticket to move further")
	private int ticketsBooked;
	private Date date;
	@NotEmpty(message = "The bus number must not be empty")
	private String busNumber;

	public BookingsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingsDTO(Long bookingId, int amount, String busNumber, int ticketsBooked, Date date) {
		super();
		this.bookingId = bookingId;
		this.amount = amount;
		this.ticketsBooked=ticketsBooked;
		this.date = date;
		this.busNumber = busNumber;
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

	@Override
	public String toString() {
		return "BookingsDTO [bookingId=" + bookingId + ", amount=" + amount + ", ticketsBooked=" + ticketsBooked
				+ ", date=" + date + ", busNumber=" + busNumber + "]";
	}

	

}
