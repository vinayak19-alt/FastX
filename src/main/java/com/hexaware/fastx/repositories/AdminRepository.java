package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx.dto.AdminDTO;
import com.hexaware.fastx.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	public Admin findByUsername(String username);
	
}
