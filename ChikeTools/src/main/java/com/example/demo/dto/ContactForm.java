package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactForm {
	@Size(max = 100)
	private String name;

	@NotBlank(message = "メールアドレスは必須です")
	@Email(message = "有効なメールアドレスを入力してください")
	private String email;

	@NotBlank(message = "件名は必須です")
	@Size(max = 150)
	private String subject;

	@NotBlank(message = "お問い合わせ内容は必須です")
	@Size(max = 5000)
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
