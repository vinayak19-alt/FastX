package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.dto.LoginDetailsDTO;
import com.hexaware.fastx.model.LoginDetails;
@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Long> {

	LoginDetails findByUsername(String username);
	
}
