package com.exampe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product2")
@Data

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String category;
	private String name;
	private Integer price;
	private String detail;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> reviews;
}