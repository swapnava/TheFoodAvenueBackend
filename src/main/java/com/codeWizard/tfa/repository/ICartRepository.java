package com.codeWizard.tfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWizard.tfa.entities.FoodCart;

@Repository
public interface ICartRepository extends JpaRepository<FoodCart,Integer>{
	
}
