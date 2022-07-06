package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	//필드
	@Autowired
	private UserDao userDao;

	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//회원가입 + 블로그 + 카테고리
	public int join(UserVo userVo) {
		
		System.out.println("UserService > join");
		
		return userDao.join(userVo);
		
	}
	
	//아이디 중복체크 (회원가입)
	public String joinCheck(String id) {
		
		System.out.println("UserService > joinCheck");
		
		UserVo userVo = userDao.joinCheck(id);
		
		if(userVo == null) {
			return "success";
		}
		
		return "fail";
		
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		
		System.out.println("UserService > login");
		
		UserVo authUser = userDao.login(userVo);
		
		return authUser;
		
	}

}
