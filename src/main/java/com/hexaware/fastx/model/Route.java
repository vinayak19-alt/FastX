package com.hexaware.fastx.model;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "route")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private Long id;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "daparture_date")
	private String departDate;
	
	@Column(name = "departure_time")
	private String departTime;
	
	@Column(name = "arrival_time")
	private String arrTime;
	
	@Column(name = "price")
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;
	
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
	private List<Bookings> booking;

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Route(String source, String destination, String departDate, String departTime, String arrTime, int price) {
		super();
		this.source = source;
		this.destination = destination;
		this.departDate = departDate;
		this.departTime = departTime;
		this.arrTime = arrTime;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Bookings> getBooking() {
		return booking;
	}

	public void setBooking(List<Bookings> booking) {
		this.booking = booking;
	}
	
	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", source=" + source + ", destination=" + destination + ", departDate=" + departDate
				+ ", departTime=" + departTime + ", arrTime=" + arrTime + ", price=" + price + ", bus=" + bus
				+ ", booking=" + booking + "]";
	}

	
	
	

}
