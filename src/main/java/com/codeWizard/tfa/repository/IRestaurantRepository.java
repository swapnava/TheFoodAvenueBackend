package com.codeWizard.tfa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWizard.tfa.entities.Restaurant;
@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer>{
	public List<Restaurant> findByRestaurantName(String name);
	public List<Restaurant> findByCategory(String category);
}
