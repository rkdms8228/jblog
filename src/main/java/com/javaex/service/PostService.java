package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	//필드
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private PostDao postDao;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트
	public Map<String, Object> postList(String id) {
		
		System.out.println("PostService > postList");
		
		Map<String, Object> blogMap = new HashMap<String, Object>();
		blogMap.put("blogVo", blogDao.main(id)); //헤더
		blogMap.put("categoryList", categoryDao.postList(id)); //카테고리 리스트
		
		return blogMap;
		
	}
	
	//글쓰기
	public int write(PostVo postVo) {
		
		System.out.println("PostService > write");
		
		return postDao.write(postVo);
		
	}

}
