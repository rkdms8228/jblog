package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	//필드
	@Autowired
	private CategoryDao categoryDao;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//카테고리 리스트
	public List<CategoryVo> categoryList(String id) {
		
		System.out.println("CategoryService > categoryList");
		
		return categoryDao.categoryList(id);
		
	}
	
	//카테고리 추가
	public CategoryVo categoryAdd(CategoryVo categoryVo) {
		
		System.out.println("CategoryService > categoryAdd");
		
		categoryDao.categoryAdd(categoryVo);
		
		return categoryDao.categoryOne(categoryVo.getCateNo());
	}

	//카테고리 삭제
	public String categoryDelete(CategoryVo categoryVo) {
		
		System.out.println("CategoryService > categoryDelete");
		
		if(categoryVo.getPostCnt() != 0) {	
			return "fail";
		}else {
			int count = categoryDao.categoryDelete(categoryVo);
			
			if(count < 0) {
				return "fail";
			}
			
			return "success";

		}
	}

}
