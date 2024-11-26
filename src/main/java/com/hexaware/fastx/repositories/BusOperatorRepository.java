package com.hexaware.fastx.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.model.BusOperator;
import com.hexaware.fastx.model.LoginDetails;
import com.hexaware.fastx.model.User;
@Repository
public interface BusOperatorRepository extends JpaRepository<BusOperator, Long>{
	
	public BusOperator findByUsername(String username);
	
	Optional<BusOperator> findByLoginDetails(LoginDetails loginDetails);
	
	public boolean existsByUsername(String username);

}
