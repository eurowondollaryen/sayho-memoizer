package com.sayho.memoizer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayho.memoizer.dao.QuizDao;

@Service
public class QuizService {
	@Autowired
	QuizDao dao;
	
	//전체 사용자 조회
	public List<Map<String, Object>> quizList(){
			
			return dao.quizList();
	}
}
