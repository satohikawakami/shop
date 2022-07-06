package com.exampe.forms;

import com.exampe.entity.Product;

import lombok.Data;

@Data
public class ReviewForm {

	private Integer id;
	private Product productId;
	private String name;
	private String contents;
	private String date;
	private String userName;
}

