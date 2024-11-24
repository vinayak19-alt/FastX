package com.hexaware.fastx.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);
	
}
