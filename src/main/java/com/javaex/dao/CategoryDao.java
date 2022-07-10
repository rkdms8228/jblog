package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//카테고리 리스트
	public List<CategoryVo> categoryList(String id) {
		
		System.out.println("CategoryDao > categoryList");
		
		return sqlSession.selectList("category.categoryList", id);
		
	}
	
	//카테고리 추가
	public int categoryAdd(CategoryVo cateVo) {
		
		System.out.println("CategoryDao > categoryAdd");
		
		return sqlSession.insert("category.categoryAdd", cateVo);
		
	}

	//카테고리 추가(1개 정보 가져오기)
	public CategoryVo categoryOne(int cateNo) {
		
		System.out.println("CategoryDao > categoryOne");
		
		return sqlSession.selectOne("category.categoryOne", cateNo);
		
	}
	
	//카테고리 삭제
	public int categoryDelete(CategoryVo cateVo) {
		
		System.out.println("CategoryDao > categoryDelete");
		
		return sqlSession.delete("category.categoryDelete", cateVo);
		
	}

}
