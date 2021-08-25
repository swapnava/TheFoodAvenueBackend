package com.codeWizard.tfa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWizard.tfa.entities.Bill;

@Repository
public interface IBillRepository extends JpaRepository<Bill,String>{
	public List<Bill> findByBillDate(LocalDate date);
	public List<Bill> findByCustomerId(String customerId);
}
