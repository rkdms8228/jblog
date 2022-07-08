package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

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
		
		Map<String, Object> blogMap = new HashMap<String, Object>();
		blogMap.put("blogVo", blogDao.main(id));
		
		return blogMap;
		
	}
	
	//내 블로그 관리
	public Map<String, Object> header(String id) {
		
		System.out.println("BlogService > header");
		
		Map<String, Object> blogMap = new HashMap<String, Object>();
		blogMap.put("blogVo", blogDao.header(id));
		
		return blogMap;
		
	}

}
