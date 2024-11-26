package com.hexaware.fastx.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.model.Route;
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
	
	public List<Route> findByDepartDateAndSourceAndDestination(String departDate, String source, String destination);

}
