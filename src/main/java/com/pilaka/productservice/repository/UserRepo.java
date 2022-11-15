package com.pilaka.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilaka.productservice.entity.Users;
 

public interface UserRepo extends JpaRepository<Users, Long> {
	
	Users findByEmail(String eamil);

}
