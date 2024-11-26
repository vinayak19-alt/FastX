package com.hexaware.fastx.dto;

import java.util.List;

import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.model.Route;
import com.hexaware.fastx.model.TransactionReport;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class BusDTO {

	private Long busId;
	@NotEmpty(message = "The bus number must not be empty")
	private String busNumber;
	@NotEmpty(message = "Please enter bus type")
	private String busType;
	@Min(value = 10, message = "Please enter valid number of seats(more than 10)")
	private int seats;
	
	private List<Long> routeIds;
	
	private Long busOperatorId;
	
	private List<Long> bookingIds;
	
	private List<Long> reportIds;

	public BusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusDTO(Long busId, String busNumber, String busType, int seats, List<Long> routeIds, Long busOperatorId,
			List<Long> bookingIds, List<Long> reportIds) {
		super();
		this.busId = busId;
		this.busNumber = busNumber;
		this.busType = busType;
		this.seats = seats;
		this.routeIds = routeIds;
		this.busOperatorId = busOperatorId;
		this.bookingIds = bookingIds;
		this.reportIds = reportIds;
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

	public List<Long> getRouteIds() {
		return routeIds;
	}

	public void setRouteIds(List<Long> routeIds) {
		this.routeIds = routeIds;
	}

	public Long getBusOperatorId() {
		return busOperatorId;
	}

	public void setBusOperatorId(Long busOperatorId) {
		this.busOperatorId = busOperatorId;
	}

	public List<Long> getBookingIds() {
		return bookingIds;
	}

	public void setBookingIds(List<Long> bookingIds) {
		this.bookingIds = bookingIds;
	}

	public List<Long> getReportIds() {
		return reportIds;
	}

	public void setReportIds(List<Long> reportIds) {
		this.reportIds = reportIds;
	}

	@Override
	public String toString() {
		return "BusDTO [busId=" + busId + ", busNumber=" + busNumber + ", busType=" + busType + ", seats=" + seats
				+ ", routeIds=" + routeIds + ", busOperatorId=" + busOperatorId + ", bookingIds=" + bookingIds
				+ ", reportIds=" + reportIds + "]";
	}

	

}
