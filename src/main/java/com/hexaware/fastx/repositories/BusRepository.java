package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {
	
	public Bus findByBusNumber(String busNumber);

}
