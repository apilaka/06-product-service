package com.pilaka.productservice.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pilaka.productservice.dto.Coupon;
import com.pilaka.productservice.entity.Product;
import com.pilaka.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/productapi")
public class ProductController {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	private String couponServiceUrl ;
	
	 	

	@RequestMapping(value="/products", method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
	Coupon coupon=	restTemplate.getForObject(couponServiceUrl+product.getCouponCode(), Coupon.class);
	product.setPrice(product.getPrice()-coupon.getDiscount());
		return repo.save(product);
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") Long id) {
		
		return repo.findById(id).get();
	}


}
