package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//글 추가하기
	public int write(PostVo postVo) {
		
		System.out.println("PostDao > write");
		
		return sqlSession.insert("post.write", postVo);
		
	}

}
