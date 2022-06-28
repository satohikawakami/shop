package com.exampe.auth;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	private String password;
	private String authority;
	
	public enum Authority {
		ADMIN,
		USER,
	}
	
}
