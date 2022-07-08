package com.javaex.dao;

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
	public BlogVo main(String id) {
		
		System.out.println("BlogDao > make");
		
		return sqlSession.selectOne("blog.main", id);
		
	}
	
	//기본 설정 변경
	public int upload(BlogVo blogVo) {
		
		System.out.println("BlogDao > upload");
		
		int count = sqlSession.update("blog.upload", blogVo);
		
		return count;
		
	}

}
