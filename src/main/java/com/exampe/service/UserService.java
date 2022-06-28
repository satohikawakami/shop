package com.exampe.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exampe.auth.User;
import com.exampe.auth.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.experimental.var;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	public void create(String username, String password, String authority) {
		var encodedPassword = passwordEncoder.encode(password);
		userRepository.insert(username, encodedPassword, authority);
	}
	
}

