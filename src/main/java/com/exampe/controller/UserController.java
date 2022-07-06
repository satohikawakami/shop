package com.exampe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exampe.forms.UserForm;
import com.exampe.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping
	public String showList(Model model) {
		
		model.addAttribute("userList", userService.findAll());
		return "users/list";
	}
	
	@GetMapping("/creationForm")
	public String showcreationForm(UserForm userForm) {
		return "users/creationForm";
	}
	
	@PostMapping("/creationForm")
	public String showcreationFormBack(@ModelAttribute UserForm userForm) {
		return "users/creationForm";
	}
	
	@PostMapping("/creationConfirm")
	public String showcreationConfirm(@Validated UserForm userForm, 
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "users/creationForm";
		}
		return "users/creationConfirm";
	}
	
	@PostMapping("/creationComplete")
	public String create(@Validated UserForm userForm, 
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "users/creationForm";
		}
		
		userService.create(userForm.getUsername(), userForm.getPassword(), userForm.getAuthority());
		return "redirect:/users";
	}
	
	@PostMapping("/deleteConfirm/{id}")
	public String deleteConfirm() {
		return "users/deleteConfirm";
	}
	
}

