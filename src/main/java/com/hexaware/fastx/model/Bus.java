package com.hexaware.fastx.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.w3c.dom.ls.LSException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bus_id")
	private Long busId;
	
	@Column(name = "bus_number")
	private String busNumber;
	
	@Column(name = "bus_type")
	private String busType;
	
	@Column(name = "bus_seats")
	private int seats;
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Route> route;
	
	@ManyToOne
	@JoinColumn(name = "operator_id")
	private BusOperator busOperator;
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<Bookings> bookings;
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<TransactionReport> reports;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(String busNumber, String busType, int seats) {
		super();
		this.busNumber = busNumber;
		this.busType = busType;
		this.seats = seats;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public List<Route> getRoute() {
		return route;
	}

	public void setRoute(List<Route> route) {
		this.route = route;
	}

	public BusOperator getBusOperator() {
		return busOperator;
	}

	public void setBusOperator(BusOperator busOperator) {
		this.busOperator = busOperator;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	public List<TransactionReport> getReports() {
		return reports;
	}

	public void setReports(List<TransactionReport> reports) {
		this.reports = reports;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busNumber=" + busNumber + ", busType=" + busType + ", seats=" + seats
				+ ", route=" + route + ", busOperator=" + busOperator + ", bookings=" + bookings + ", reports="
				+ reports + "]";
	}

	
	
}
