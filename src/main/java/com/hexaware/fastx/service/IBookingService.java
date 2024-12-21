package com.hexaware.fastx.service;

import java.util.List;

import com.hexaware.fastx.dto.BookingsDTO;
import com.hexaware.fastx.model.Bookings;
import com.hexaware.fastx.model.User;

public interface IBookingService {
	
	public BookingsDTO makeReservation(Bookings booking);
	List<BookingsDTO> getBookingsForUser(String username);
	public String cancelReservation(Long id);
	public List<BookingsDTO> getBookingsForBus(Long id);

}
