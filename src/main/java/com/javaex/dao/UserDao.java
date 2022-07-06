package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//회원가입
	public int join(UserVo userVo) {
		
		System.out.println("UserDao > join");
		
		return sqlSession.insert("user.join", userVo);
		
	}
	
	//아이디 중복체크 (회원가입)
	public UserVo joinCheck(String id) {
		
		System.out.println("UserDao > joinCheck");
		
		UserVo authUser = sqlSession.selectOne("user.joinCheck", id);
		
		return authUser;
		
	}
	
	//회원정보 가져오기(로그인)
	public UserVo login(UserVo userVo) {
		
		System.out.println("UserDao > login");
		
		UserVo authUser = sqlSession.selectOne("user.login", userVo);
		
		return authUser;
		
	}

}
