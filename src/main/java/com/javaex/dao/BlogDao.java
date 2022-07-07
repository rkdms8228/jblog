package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//블로그 생성
	public int make(BlogVo blogVo) {
		
		System.out.println("BlogDao > make");
		
		return sqlSession.insert("blog.make", blogVo);
		
	}
	
	//블로그 메인화면
	public Map<String, Object> main(String id) {
		
		System.out.println("BlogDao > make");
		
		Map<String, Object> blogMap =  sqlSession.selectOne("blog.main", id);
		
		return blogMap;
		
	}

}
