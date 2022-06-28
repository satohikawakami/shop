package com.exampe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

class IndexController {
	
	@GetMapping
	public String main() {
		return "layouts/common";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String showLogoutForm() {
		return "logout";
	}
	
}
