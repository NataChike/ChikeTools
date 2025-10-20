package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class TopController {
	@GetMapping("")
	public String index() {
		return "index";
	}
	@GetMapping("privacy-policy")
	public String privacyPolicy(){
		return "privacyPolicy";
	}
	@GetMapping("terms")
	public String Terms() {
		return "terms";
	}
}
