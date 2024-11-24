package com.hexaware.fastx.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.PaymentsDTO;
import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Payments;
import com.hexaware.fastx.repositories.BookingRepository;
import com.hexaware.fastx.repositories.PaymentsRepository;
import com.hexaware.fastx.service.IPaymentService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class PaymentService implements IPaymentService{
	
	private PaymentsRepository paymentsRepository;
	private BookingRepository bookingRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	public PaymentService(PaymentsRepository paymentsRepository, BookingRepository bookingRepository) {
		super();
		this.paymentsRepository = paymentsRepository;
		this.bookingRepository =bookingRepository;
	}


	@Override
	public PaymentsDTO makePayment(Payments payment) {
		// TODO Auto-generated method stub
		Bookings booking = bookingRepository.findByBookingId(payment.getBooking().getBookingId());
		payment.setBooking(booking);
		Payments savedPayment = this.paymentsRepository.save(payment);
		PaymentsDTO savedPaymentDTO = mapper.map(savedPayment, PaymentsDTO.class);
		return savedPaymentDTO;
	}
	
	

}
