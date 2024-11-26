package com.hexaware.fastx.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.model.Admin;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.User;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	public Admin findByUsername(String username);
	
	Optional<Admin> findByLoginDetails(LoginDetails loginDetails);
	
	public boolean existsByUsername(String username);
}
