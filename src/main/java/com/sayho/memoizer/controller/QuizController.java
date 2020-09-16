package com.sayho.memoizer.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sayho.memoizer.service.QuizService;


@RestController
public class QuizController {
	@Autowired
	QuizService service;
	
	@RequestMapping("/quiz/list")
	public Map<String, Object> list() throws Exception {//@Responsebody를 String 앞에 붙이면 문자열 그자체를 반환함
		List<Map<String, Object>> quizList = service.quizList();
		Map<String, Object> result = new HashMap<>();
		result.put("status", true);
		result.put("datetime", new Date());
		result.put("data", quizList);
		return result;
	}
	
	@RequestMapping("/quiz/regist")
	public Map<String, Object> insertQuiz(@RequestParam Map<String, Object> record,
			HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("status", true);
		result.put("datetime", new Date());
		result.put("data", service.insertQuiz(record));
		return result;
	}
	
	@RequestMapping("/quiz/delete")
	public Map<String, Object> deleteQuiz(@RequestParam Map<String, Object> record,
			HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("status", true);
		result.put("datetime", new Date());
		result.put("data", service.deleteQuiz(record));
		return result;
	}
}