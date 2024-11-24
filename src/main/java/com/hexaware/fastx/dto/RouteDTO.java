package com.hexaware.fastx.dto;

import java.sql.Time;
import java.util.List;

import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Bus;

import jakarta.persistence.OneToMany;

public class RouteDTO {

	private Long routeId;
	private String source;
	private String destination;
	private String departDate;
	private String departTime;
	private String arrTime;
	private int price;
	private Long busId;
	private String busNumber;
	private String busType;
	
	private List<Long> bookingIds;

	public RouteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RouteDTO(Long routeId, String source, String destination, String departDate, String departTime, String arrTime, int price,
			Long busId, List<Long> bookingIds, String busNumber, String busType) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.departDate=departDate;
		this.departTime = departTime;
		this.arrTime = arrTime;
		this.price = price;
		this.busId = busId;
		this.bookingIds = bookingIds;
		this.busNumber= this.busType;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
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

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public List<Long> getBookingIds() {
		return bookingIds;
	}

	public void setBookingIds(List<Long> bookingIds) {
		this.bookingIds = bookingIds;
	}
	

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
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

	@Override
	public String toString() {
		return "RouteDTO [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", departDate="
				+ departDate + ", departTime=" + departTime + ", arrTime=" + arrTime + ", price=" + price + ", busId="
				+ busId + ", busNumber=" + busNumber + ", busType=" + busType + ", bookingIds=" + bookingIds + "]";
	}

	
}
