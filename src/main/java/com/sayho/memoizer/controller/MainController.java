package com.sayho.memoizer.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	//FOR GENERATING RANDOM NUMBER
	public String generateState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString();
	}
	
	@GetMapping("/")
	public String index() {
		
		return "/main.html";
	}
	
	//CSRF 방지를 위한 토큰 생성 코드
	@GetMapping("/user/login")
	@ResponseBody
	public String login(@RequestParam Map<String, Object> record, HttpServletRequest request) {
		String state = generateState();
		request.getSession().setAttribute("state", state);
		return state;
	}
	
	@GetMapping("/error")
	public String error() {
		return "/error.html";
	}
	
	@GetMapping("/test")
	public String test() {
		return "/index.html";
	}
}
