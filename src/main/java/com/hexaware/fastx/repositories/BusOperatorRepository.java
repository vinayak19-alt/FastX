package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx.model.BusOperator;

public interface BusOperatorRepository extends JpaRepository<BusOperator, Long>{
	
	public BusOperator findByUsername(String username);

}
