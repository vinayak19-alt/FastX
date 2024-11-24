package com.hexaware.fastx.serviceimpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.customexceptions.BadRequestMadeException;
import com.hexaware.fastx.dto.RefundDTO;
import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.Refund;
import com.hexaware.fastx.repositories.BookingRepository;
import com.hexaware.fastx.repositories.PaymentsRepository;
import com.hexaware.fastx.repositories.RefundRepository;
import com.hexaware.fastx.service.IRefundService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RefundServiceImpl implements IRefundService{
	
	private RefundRepository refundRepository;
	private BookingRepository bookingRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	public RefundServiceImpl(RefundRepository refundRepository, BookingRepository bookingRepository) {
		super();
		this.refundRepository = refundRepository;
		this.bookingRepository = bookingRepository;
	}

	@Override
	public RefundDTO refundAmount(Refund refund) {
		// TODO Auto-generated method stub
		Bookings booking = this.bookingRepository.findByBookingId(refund.getBooking().getBookingId());
		if(booking ==  null) {
			throw new BadRequestMadeException("Booking for which Refund is asked is not there");
		}
		refund.setBooking(booking);
		refund.setRefundAmount(booking.getAmount());
		refund.setRefundDate(new Date());
		refund.setRefundStatus("Successful");
		Refund savedRefund = this.refundRepository.save(refund);
		booking.setStatus("Cancelled");
		bookingRepository.save(booking);
		RefundDTO savedRefundDTO = mapper.map(savedRefund, RefundDTO.class);
		return savedRefundDTO;
	}

}
