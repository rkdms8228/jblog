package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	//필드
	@Autowired
	private PostDao postDao;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//글쓰기
	public int write(PostVo postVo) {
		
		System.out.println("PostService > write");
		
		return postDao.write(postVo);
		
	}

}
