package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.model.Bus;
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
	
	public Bus findByBusNumber(String busNumber);

}
