package com.hexaware.fastx.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.dto.BookingsDTO;
import com.hexaware.fastx.model.Bookings;
@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {
	
	public Bookings findByBookingId(Long id);
	
	public List<Bookings> findByUsername(String username);

}
