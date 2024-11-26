package com.hexaware.fastx.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);
	
	Optional<User> findByLoginDetails(LoginDetails loginDetails);
	
	public boolean existsByUsername(String username);
	
	public boolean existsByEmail(String email);
	
}
