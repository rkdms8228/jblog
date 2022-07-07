package com.javaex.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;

@Service
public class BlogService {
	
	//필드
	@Autowired
	private BlogDao blogDao;
		
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//블로그 메인화면
	public Map<String, Object> main(String id) {
		
		System.out.println("BlogService > main");
		
		Map<String, Object> blogMap = blogDao.main(id);
		
		return blogMap;
		
	}

}
