package com.hexaware.fastx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.model.Refund;
@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {

}
