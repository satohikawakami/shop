package com.exampe.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exampe.entity.Product;
import com.exampe.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll(
				Sort.by(Sort.Direction.ASC, "id")
				);
	}

	public Product findById(Integer id) {
		return productRepository.findById(id).get();
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Integer id) {
		productRepository.deleteById(id);
	}
}