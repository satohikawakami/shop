package com.exampe.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.exampe.validation.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {
	
	@NotBlank(message = "（必須）お名前を入力してください。")
	@UniqueUsername
	private String username;
	
	@NotBlank(message = "（必須）パスワードを入力してください")
	@Size(min = 6, max = 128, message = "６文字以上、１２８文字以内で設定をしてください。")
	private String password;
	
	@NotBlank(message = "（必須）権限を選択してください")
	private String authority;

}
