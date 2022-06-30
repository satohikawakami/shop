package com.exampe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exampe.entity.Product;
import com.exampe.entity.ReviewForm;
import com.exampe.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor

public class ReviewController {
	
	private final ReviewService reviewService;
	
	@GetMapping("form")
	public String form(Model model, ReviewForm reviewForm) {
		List<Product> products = reviewService.findAll();
		model.addAttribute("products", products);
		return "shops/reviewForm";
	}
	
	@PostMapping("reviewConfirm")
	public String reviewConfirm(@Validated ReviewForm reviewForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "shops/reviewForm";
		}
			return "shops/reviewConfirm";
		}
	}

