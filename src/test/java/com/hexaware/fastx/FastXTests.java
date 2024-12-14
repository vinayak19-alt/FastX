package com.hexaware.fastx;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx.model.Admin;
import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.LoginDetails.Role;
import com.hexaware.fastx.model.Payments;
import com.hexaware.fastx.model.Refund;
import com.hexaware.fastx.model.Route;
import com.hexaware.fastx.model.TransactionReport;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.repositories.AdminRepository;
import com.hexaware.fastx.repositories.BookingRepository;
import com.hexaware.fastx.repositories.BusOperatorRepository;
import com.hexaware.fastx.repositories.BusRepository;
import com.hexaware.fastx.repositories.PaymentsRepository;
import com.hexaware.fastx.repositories.RefundRepository;
import com.hexaware.fastx.repositories.RouteRepository;
import com.hexaware.fastx.repositories.TransactionReportRepository;
import com.hexaware.fastx.repositories.UserRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class FastXTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BusOperatorRepository busOperatorRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private BusRepository busRepository;
	@Autowired
	private RouteRepository routeRepository;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private PaymentsRepository paymentsRepository;
	@Autowired
	private TransactionReportRepository transactionReportRepository;
	@Autowired
	private RefundRepository refundRepository;
	
	@Test
	void a_userLoginTest() {
		LoginDetails login = new LoginDetails("testUser", "testUser", Role.User);
		User user = new User("test", 20, "male", "2356984523", "testUser", "testuser@gmail.com");
		user.setLoginDetails(login);
		this.userRepository.save(user);
	}
	
	@Test
	void b_operatorLoginTest() {
		LoginDetails login = new LoginDetails("testOperator", "testOperator", Role.Operator);
		BusOperator operator = new BusOperator("optest", 25, "testOperator", "1234567890");
		operator.setLoginDetails(login);
		this.busOperatorRepository.save(operator);
	}

	@Test
	void c_adminLoginTest() {
		LoginDetails login = new LoginDetails("testAdmin", "testAdmin", Role.Admin);
		Admin admin = new Admin("admintest", "testAdmin", "9876543210");
		admin.setLoginDetails(login);
		this.adminRepository.save(admin);
	}
	
	@Test
	void d_addBusTest() {
		BusOperator operator = this.busOperatorRepository.findByUsername("testOperator");
		Bus bus = new Bus("BusTest", "AC", 30);
		bus.setBusOperator(operator);
		this.busRepository.save(bus);
	}
	
	@Test
	void e_addRouteTest() {
		Bus bus = this.busRepository.findByBusNumber("BusTest");
		Route route = new Route("source1", "destination1", "01-01-2001", "12:00", "15:00", 100);
		route.setBus(bus);
		this.routeRepository.save(route);
	}
	
	@Test 
	void f_getAllRoutesTest(){
		List<Route> routes = this.routeRepository.findByDepartDateAndSourceAndDestination("2024-11-30", "Agra", "Mumbai");
	}
	
	@Test
	void g_makeReservationTest() {
		User user = this.userRepository.findByUsername("testUser");
		Bus bus = this.busRepository.findByBusNumber("BusTest");
		Bookings booking = new Bookings(2, 200, user.getUsername(), bus.getBusNumber(), "successful", new Date());
		booking.setUser(user);
		booking.setBus(bus);
		booking.setRoute(bus.getRoute().get(0));
		this.bookingRepository.save(booking);
		Payments payment = new Payments(new Date(), booking.getAmount(), "Successful");
		payment.setUser(user);
		payment.setBooking(booking);
		this.paymentsRepository.save(payment);
		TransactionReport report = new TransactionReport(new Date());
		report.setUser(user);
		report.setBooking(booking);
		report.setBus(bus);
		report.setPayment(payment);
		this.transactionReportRepository.save(report);
		
	}
	
	@Test
	void h_getBookingsForUser() {
		List<Bookings> bookings = this.bookingRepository.findByUsername("vinayak");
	}
	
	@Test
	void i_getAllUsers() {
		List<User> users = this.userRepository.findAll(); 
	}
	@Test
	void j_deleteOperator() {
		BusOperator operator = busOperatorRepository.findByUsername("testOperator");
		this.busOperatorRepository.deleteById(operator.getOperatorId());
	}
	
	@Test
	void k_refundAmountTest() {
		Bookings booking = bookingRepository.findByBookingId(4L);
		Refund refund = new Refund(new Date(), booking.getAmount(), "Successful");
		booking.setStatus("Cancelled");
		this.refundRepository.save(refund);
		this.bookingRepository.save(booking);
	}
	@Test
	void l_deleteUserTest() {
		User user = userRepository.findByUsername("testUser");
		this.userRepository.deleteById(user.getId());
	}
	
}
