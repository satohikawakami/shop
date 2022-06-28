package com.exampe.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProductForm {
	
	private Integer id;
	
	@NotBlank(message = "カテゴリーを入力してください")
	private String category;
	
	@NotBlank(message = "商品名を入力してください")
	private String name;
	
	@NotNull(message = "価格を入力してください")
	private Integer price;
	
	@NotBlank(message = "説明を入力してください")
	@Size(max = 255, message = "255文字以内でご入力ください")
	private String detail;
	
}