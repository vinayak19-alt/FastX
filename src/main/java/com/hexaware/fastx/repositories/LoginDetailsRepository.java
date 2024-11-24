package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx.dto.LoginDetailsDTO;
import com.hexaware.fastx.model.LoginDetails;

public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Long> {

	LoginDetails findByUsername(String username);
	
}
