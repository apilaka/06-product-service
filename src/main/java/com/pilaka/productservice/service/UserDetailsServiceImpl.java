package com.pilaka.productservice.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pilaka.productservice.entity.Role;
import com.pilaka.productservice.entity.Users;
import com.pilaka.productservice.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("load user");
		
		
		Users user = userRepo.findByEmail(email);
		if (null == user) {
			throw new UsernameNotFoundException("User does not exist" + user.getEmail());
		}
		System.out.println(user.toString());
		String username = user.getEmail();
		String password = user.getPassword();
		Set<Role> authorities = user.getRoles();
		return new org.springframework.security.core.userdetails.User(username, password, authorities);

	}

}
