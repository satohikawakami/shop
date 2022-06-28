package com.exampe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exampe.entity.Product;
import com.exampe.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/shop")

public class ShopController {
	
	private final ProductService productService;
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "shops/index";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable Integer id, Model model) {
		
		model.addAttribute("product",productService.findById(id));
		
		return "shops/show";
	}
	
	
	
}

