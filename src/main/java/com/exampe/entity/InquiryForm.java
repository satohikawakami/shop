package com.exampe.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class InquiryForm {
	
	@NotBlank(message = "（必須）お名前の入力は必須です。")
	private String name;
	
	@NotBlank(message = "（必須）カタカナの入力は必須です。")
	private String kana;
	
	@NotBlank(message = "（必須）メールアドレスの入力は必須です。")
	private String email;
	
	@NotBlank(message = "（必須）お問い合わせ内容の入力は必須です。")
	@Size(min = 3, max = 500, message="3文字以上、500文字以内でご入力ください。")
	private String comment;
	
}