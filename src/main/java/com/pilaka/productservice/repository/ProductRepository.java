package com.pilaka.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilaka.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
