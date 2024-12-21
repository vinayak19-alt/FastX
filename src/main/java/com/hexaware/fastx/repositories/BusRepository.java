package com.hexaware.fastx.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.dto.BusDTO;
import com.hexaware.fastx.model.Bus;
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
	
	public Bus findByBusNumber(String busNumber);
	
//	@Query(value = "SELECT b.id AS bus_id,b.bus_name,o.id AS operator_id,o.name AS operator_name,bk.id AS booking_id,bk.passenger_name,bk.booking_date FROM operator o JOIN bus b ON o.id = b.operator_id JOIN booking bk ON b.id = bk.bus_id WHERE o.id = :OPERATOR_ID", nativeQuery = true)
//	List<Object[]> findBookingsByOperatorId(@Param("operatorId") Long operatorId);
	
	@Query(value = "SELECT * FROM bus WHERE operator_id=:id", nativeQuery = true)
	public List<Bus> findByOperatorId(Long id);

}
