package com.hexaware.fastx.model;

import java.sql.Time;
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
@Table(name = "bookings")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Long bookingId;

	@Column(name = "username")
	private String username;

	@Column(name = "tickets_booked")
	private int ticketsBooked;

	@Column(name = "bus_number")
	private String busNumber;

	@Column(name = "amount")
	private int amount;

	@Column(name = "date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	@OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
	private Refund refund;

	@Column(name = "status")
	private String status;

	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	private Payments payment;

	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	private TransactionReport transactionReport;

	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;

	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookings(int ticketsBooked, int amount, String username,String busNumber, String status, Date date) {
		super();
		this.amount = amount;
		this.username = username;
		this.ticketsBooked = ticketsBooked;
		this.busNumber = busNumber;
		this.status = status;
		this.date = date;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Refund getRefund() {
		return refund;
	}

	public void setRefund(Refund refund) {
		this.refund = refund;
	}

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	public TransactionReport getTransactionReport() {
		return transactionReport;
	}

	public void setTransactionReport(TransactionReport transactionReport) {
		this.transactionReport = transactionReport;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public int getTicketsBooked() {
		return ticketsBooked;
	}

	public void setTicketsBooked(int ticketsBooked) {
		this.ticketsBooked = ticketsBooked;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", username=" + username + ", ticketsBooked=" + ticketsBooked
				+ ", busNumber=" + busNumber + ", amount=" + amount + ", date=" + date + ", user=" + user + ", bus="
				+ bus + ", refund=" + refund + ", status=" + status + ", payment=" + payment + ", transactionReport="
				+ transactionReport + ", route=" + route + "]";
	}

}
