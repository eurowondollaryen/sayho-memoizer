package com.sayho.memoizer.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	private String CLIENT_ID = "a7c6RelyzCX6EJUpkB63"; //애플리케이션 클라이언트 아이디값";
	private String CLI_SECRET = "EP5dXHm7rH"; //애플리케이션 클라이언트 시크릿값";
	
	/*
	 * 메인화면(소개화면) - 여기서 로그인해서 /index로 이동할 수 있다. 
	 */
	@GetMapping("/")
	public String mainPage() {
		
		return "/main.html";
	}
	
	@GetMapping("/error")
	public String errorPage() {
		return "/error.html";
	}
	
	/*
	 *  
	 */
	@GetMapping("/index")
	public String indexPage() {
		
		return "/index.html";
	}
	
	/*
	 * 로그인 화면
	 *  
	 */
	@GetMapping("/login")
	public String loginPage(HttpSession session, Model model) throws UnsupportedEncodingException, UnknownHostException {
		String redirectURI = URLEncoder.encode("http://localhost:8080/naver/callback1", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += String.format("&client_id=%s&redirect_uri=%s&state=%s",
	        CLIENT_ID, redirectURI, state);
	    session.setAttribute("state", state);
	    model.addAttribute("apiURL", apiURL);
		return "/login.html";
	}
}
