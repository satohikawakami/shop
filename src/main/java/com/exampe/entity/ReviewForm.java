package com.exampe.entity;

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

