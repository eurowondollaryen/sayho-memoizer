package com.sayho.memoizer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCallbackController {
	//네이버 로그인 성공 시 callback 호출 메소드
	@RequestMapping("naverLoginCallback")
	public void naverLoginCallBack(HttpServletRequest request, HttpServletResponse response, @RequestParam String code, @RequestParam String state, HttpSession session) throws Exception {
		System.out.println("[김세호][LoginCallbackController] callback start...");
		
	}
}
