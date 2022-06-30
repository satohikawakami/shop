package com.exampe.entity;

import lombok.Data;

@Data
public class ReviewForm {

	private Integer id;
	private Integer product_id;
	private String name;
	private String contents;
	private String date;
}
