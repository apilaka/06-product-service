package com.pilaka.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilaka.productservice.entity.Role;


public interface RoleRepo extends JpaRepository<Role, Long> {
	
	 
}
