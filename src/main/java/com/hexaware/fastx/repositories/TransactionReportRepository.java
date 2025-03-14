package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.dto.TransactionReportDTO;
import com.hexaware.fastx.model.TransactionReport;
@Repository
public interface TransactionReportRepository extends JpaRepository<TransactionReport, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM report r WHERE r.booking_id = :bookingId")
	public TransactionReport generateReport(long bookingId);

}
