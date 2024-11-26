package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.model.Payments;
@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {

}
