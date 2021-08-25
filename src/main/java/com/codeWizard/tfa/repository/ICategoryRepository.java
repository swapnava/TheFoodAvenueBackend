package com.codeWizard.tfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWizard.tfa.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer>{

}
