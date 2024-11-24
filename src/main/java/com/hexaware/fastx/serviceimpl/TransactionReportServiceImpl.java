package com.hexaware.fastx.serviceimpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.BadRequestMadeException;
import com.hexaware.fastx.customexceptions.EntityNotFoundException;
import com.hexaware.fastx.customexceptions.ResourceNotAvailableException;
import com.hexaware.fastx.dto.TransactionReportDTO;
import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Bus;
import com.hexaware.fastx.model.TransactionReport;
import com.hexaware.fastx.model.User;
import com.hexaware.fastx.repositories.BookingRepository;
import com.hexaware.fastx.repositories.BusRepository;
import com.hexaware.fastx.repositories.TransactionReportRepository;
import com.hexaware.fastx.repositories.UserRepository;
import com.hexaware.fastx.service.ITransactionReportService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionReportServiceImpl implements ITransactionReportService{
	
	private TransactionReportRepository transactionReportRepository;
	private BookingRepository bookingRepository;
	private BusRepository busRepository;
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public TransactionReportServiceImpl(TransactionReportRepository transactionReportRepository,
			BookingRepository bookingRepository, BusRepository busRepository, UserRepository userRepository) {
		super();
		this.transactionReportRepository = transactionReportRepository;
		this.bookingRepository = bookingRepository;
		this.busRepository = busRepository;
		this.userRepository = userRepository;
	}

	@Override
	public TransactionReportDTO getReport(Long bookingId) {
		// TODO Auto-generated method stub
		this.bookingRepository.findById(bookingId)
		.orElseThrow(() -> new BadRequestMadeException("Booking details not found"));
		TransactionReport report = transactionReportRepository.generateReport(bookingId);
		TransactionReportDTO reportDTO = mapper.map(report, TransactionReportDTO.class);
		return reportDTO;
	}



	@Override
	public TransactionReportDTO makeReport(TransactionReport report) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(report.getUser().getUsername());
		if(user == null) {
			throw new EntityNotFoundException("User", "Database");
		}
		Bookings booking = bookingRepository.findByBookingId(report.getBooking().getBookingId());
		if(booking == null) {
			throw new BadRequestMadeException("Booking details not available");
		}
		Bus bus = busRepository.findByBusNumber(report.getBus().getBusNumber());
		if(bus == null) {
			throw new ResourceNotAvailableException("Bus is not available");
		}
		report.setUser(user);
		report.setBooking(booking);
		report.setReportDate(new Date());
		report.setBus(bus);
		TransactionReport savedReport = this.transactionReportRepository.save(report);
		TransactionReportDTO savedReportDTO = mapper.map(savedReport, TransactionReportDTO.class);
		return savedReportDTO;
	}

}
