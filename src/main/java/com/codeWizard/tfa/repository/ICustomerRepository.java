package com.codeWizard.tfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWizard.tfa.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

}
