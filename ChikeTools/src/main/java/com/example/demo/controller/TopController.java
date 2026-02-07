package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.CurrentUserService;

@Controller("/")
public class TopController {
	@Autowired
	CurrentUserService currentUserService;

	@GetMapping("")
	public String index() {
		return "index";
	}

	@GetMapping("profile")
	public String profile() {
		return "profile";
	}

	@GetMapping("privacy-policy")
	public String privacyPolicy() {
		return "privacyPolicy";
	}

	@GetMapping("terms")
	public String Terms() {
		return "terms";
	}
}
