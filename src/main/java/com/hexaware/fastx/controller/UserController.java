package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.BookingsDTO;
import com.hexaware.fastx.dto.RefundDTO;
import com.hexaware.fastx.dto.RouteDTO;
import com.hexaware.fastx.dto.TransactionReportDTO;
import com.hexaware.fastx.dto.UserDTO;
import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Refund;
import com.hexaware.fastx.model.TransactionReport;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.serviceimpl.BookingService;
import com.hexaware.fastx.serviceimpl.RefundServiceImpl;
import com.hexaware.fastx.serviceimpl.RouteServiceImpl;
import com.hexaware.fastx.serviceimpl.TransactionReportServiceImpl;
import com.hexaware.fastx.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/saveuser/v1/")
public class UserController {

	private UserServiceImpl userServiceImpl;
	private BookingService bookingService;
	private RefundServiceImpl refundServiceImpl;
	private RouteServiceImpl routeServiceImpl;
	private TransactionReportServiceImpl transactionReportServiceImpl;

	@Autowired
	public UserController(UserServiceImpl userServiceImpl, BookingService bookingService, RefundServiceImpl refundServiceImpl,
			RouteServiceImpl routeServiceImpl, TransactionReportServiceImpl transactionReportServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
		this.bookingService = bookingService;
		this.refundServiceImpl = refundServiceImpl;
		this.routeServiceImpl = routeServiceImpl;
		this.transactionReportServiceImpl = transactionReportServiceImpl;
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user){
		return ResponseEntity.ok(this.userServiceImpl.addUser(user));
	}
	
	@PostMapping("/makeReservation")
	public ResponseEntity<BookingsDTO> makeReservation(@RequestBody Bookings booking){
		return ResponseEntity.ok(this.bookingService.makeReservation(booking));
	}
	
	@GetMapping("/getBookings/{username}")
	public ResponseEntity<List<BookingsDTO>> getBookingsForUser(@PathVariable("username") String username){
		return ResponseEntity.ok(this.bookingService.getBookingsForUser(username));
	}
	
	@PostMapping("/cancelReservation")
	public ResponseEntity<RefundDTO> cancelReservation(@RequestBody Refund refund){
		return ResponseEntity.ok(this.refundServiceImpl.refundAmount(refund));
	}
	@GetMapping("/getRoutes/{departDate}/{source}/{destination}")
	public ResponseEntity<List<RouteDTO>> getAllRoutes(@PathVariable("departDate") String departDate,
														@PathVariable("source") String source,
														@PathVariable("destination") String destination){
		return ResponseEntity.ok(this.routeServiceImpl.getAllRoutes(departDate, source, destination));
	}
	@PostMapping("/addTransaction")
	public ResponseEntity<TransactionReportDTO> makeReport(@RequestBody TransactionReport report){
		return ResponseEntity.ok(this.transactionReportServiceImpl.makeReport(report));
	}
	
}
