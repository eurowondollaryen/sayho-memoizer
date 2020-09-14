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
 
 	public List<Map<String, Object>> quizList(){
 		return sqlSession.selectList(NAME_SPACE+"testQuery");
	}
}