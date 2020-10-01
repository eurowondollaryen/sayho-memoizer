package com.sayho.memoizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "/index.html";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/login.jsp";
	}
	
	@GetMapping("/error")
	public String error() {
		return "/error.html";
	}
}
