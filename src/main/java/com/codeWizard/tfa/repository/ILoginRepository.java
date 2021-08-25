package com.codeWizard.tfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWizard.tfa.entities.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login,Integer>{
	
	public Login findByUserName(String username);
}
