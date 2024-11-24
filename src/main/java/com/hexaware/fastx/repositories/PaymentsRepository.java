package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx.model.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {

}
