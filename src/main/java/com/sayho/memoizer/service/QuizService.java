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
	
	public List<Map<String, Object>> quizList(Map<String, Object> record){
			return dao.quizList(record);
	}
	
	public List<Map<String, Object>> questionList(Map<String, Object> record){
		return dao.questionList(record);
}
	
	public int insertQuiz(Map<String, Object> record){
		return dao.insertQuiz(record);
	}
	
	public int deleteQuiz(Map<String, Object> record){
		return dao.deleteQuiz(record);
	}
	
	public int insertQuestion(Map<String, Object> record){
		return dao.insertQuestion(record);
	}
}
