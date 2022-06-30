package com.exampe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exampe.entity.Product;
import com.exampe.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ReviewService {
	
	private final ProductRepository productRepository;
	
	
	public List<Product> findAll(){
		return productRepository.findAll();
		
	}
	
	public Product findById(Integer id) {
		return productRepository.findById(id).get();
	}
	

}
