package com.hexaware.fastx.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.EntityNotFoundException;
import com.hexaware.fastx.customexceptions.ResourceNotAvailableException;
import com.hexaware.fastx.dto.BookingsDTO;
import com.hexaware.fastx.dto.TransactionReportDTO;
import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.Payments;
import com.hexaware.fastx.model.TransactionReport;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.repositories.BookingRepository;
import com.hexaware.fastx.repositories.BusRepository;
import com.hexaware.fastx.repositories.PaymentsRepository;
import com.hexaware.fastx.repositories.RouteRepository;
import com.hexaware.fastx.repositories.TransactionReportRepository;
import com.hexaware.fastx.repositories.UserRepository;
import com.hexaware.fastx.service.IBookingService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class BookingService implements IBookingService {
	
	Logger logger=LoggerFactory.getLogger(BookingService.class);
	
	private BookingRepository bookingRepository;
	private UserRepository userRepository;
	private BusRepository busRepository;
	private PaymentsRepository paymentsRepository;
	private RouteRepository routeRepository;
	private TransactionReportRepository transactionReportRepository;
	
	
	@Autowired
	public BookingService(BookingRepository bookingRepository, UserRepository userRepository,
			BusRepository busRepository, PaymentsRepository paymentsRepository, RouteRepository routeRepository,
			TransactionReportRepository transactionReportRepository) {
		super();
		this.bookingRepository = bookingRepository;
		this.userRepository = userRepository;
		this.busRepository = busRepository;
		this.paymentsRepository = paymentsRepository;
		this.routeRepository = routeRepository;
		this.transactionReportRepository=transactionReportRepository;
	}
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public BookingsDTO makeReservation(Bookings booking) {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByUsername(booking.getUsername());
		if(user == null) {
			throw new EntityNotFoundException("User", "System");
		}
		
		Bus bus = this.busRepository.findByBusNumber(booking.getBusNumber());
		if(bus == null) {
			throw new ResourceNotAvailableException("Bus for this number is not available");
		}
		if(bus.getSeats() < booking.getTicketsBooked()) {
			throw new ResourceNotAvailableException("The number of seats you are trying to book are not available");
		}
		booking.setUser(user);
		booking.setBus(bus);
		booking.setRoute(bus.getRoute().get(0));
		booking.setDate(new Date());
		booking.setAmount(bus.getRoute().get(0).getPrice() * booking.getTicketsBooked());
		booking.setStatus("Successful");
		Bookings savedBooking = this.bookingRepository.save(booking);
		bus.setSeats(bus.getSeats()-booking.getTicketsBooked());
		this.busRepository.save(bus);
		
		Payments payment = new Payments();
	    payment.setBooking(savedBooking);
	    payment.setUser(user);
	    payment.setPaymentDate(new Date());
	    payment.setAmount(savedBooking.getAmount()); 
	    payment.setPaymentStatus("Success"); 
	    
	    this.paymentsRepository.save(payment);
	    TransactionReport report = new TransactionReport();
	    report.setUser(user);
	    report.setBooking(savedBooking);
	    report.setBus(bus);
	    report.setReportDate(new Date());
	    report.setPayment(payment);
	    TransactionReport savedReport =  this.transactionReportRepository.save(report);
	    TransactionReportDTO savedReportDTO = mapper.map(savedReport, TransactionReportDTO.class);
		BookingsDTO savedBookingDTO = mapper.map(savedBooking, BookingsDTO.class);
		return savedBookingDTO;
	}

	@Override
	public List<BookingsDTO> getBookingsForUser(String username) {
		// TODO Auto-generated method stub
		List<BookingsDTO> bookingDTOs = new ArrayList<>();
		List<Bookings> bookings = bookingRepository.findByUsername(username);
		if(bookings.size() == 0) {
			logger.error("ResourceNotAvailableException ");
			throw new ResourceNotAvailableException("Bookings for this user are not available");
		}
		bookings.forEach((b) -> {
			bookingDTOs.add(mapper.map(b, BookingsDTO.class));
		});
		
		return bookingDTOs;
	}


}
