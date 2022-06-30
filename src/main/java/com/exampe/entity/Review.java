package com.exampe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "review3")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String contents;
	private String date;
	
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public void setProduct_id(Integer product_id) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setUsername(String userName) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}