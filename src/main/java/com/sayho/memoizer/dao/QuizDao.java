package com.sayho.memoizer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDao {
	@Autowired
	private SqlSession sqlSession;
	
	private static String NAME_SPACE = "com.sayho.memoizer.dao.QuizDao.";
 
 	public List<Map<String, Object>> quizList(Map<String, Object> record){
 		return sqlSession.selectList(NAME_SPACE+"quizList", record);
	}
 	
 	public List<Map<String, Object>> questionList(Map<String, Object> record){
 		return sqlSession.selectList(NAME_SPACE+"questionList", record);
	}
 	
 	public List<Map<String, Object>> questionCount(Map<String, Object> record){
 		return sqlSession.selectList(NAME_SPACE+"questionCount", record);
	}
 	
 	public int insertQuiz(Map<String, Object> record){
 		return sqlSession.insert(NAME_SPACE+"insertQuiz", record);
	}
 	
 	public int deleteQuiz(Map<String, Object> record){
 		return sqlSession.delete(NAME_SPACE+"deleteQuiz", record);
	}
 	
 	public int deleteQuestion(Map<String, Object> record){
 		return sqlSession.delete(NAME_SPACE+"deleteQuestion", record);
	}

 	public int insertQuestion(Map<String, Object> record){
 		return sqlSession.insert(NAME_SPACE+"insertQuestion", record);
	}
}