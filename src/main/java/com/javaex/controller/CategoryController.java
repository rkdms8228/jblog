package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping(value="/{id}/admin")
public class CategoryController {
	
	//필드
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//회원가입폼
	@RequestMapping(value="/category", method={RequestMethod.GET, RequestMethod.POST})
	public String category(Model model, @PathVariable String id) {
		
		System.out.println("CategoryController > category");
		
		//해더 이름 띄우기
		Map<String, Object> blogMap = blogService.main(id);
		model.addAttribute("blogMap", blogMap);
		
		return "blog/admin/blog-admin-cate";
		
	}
	
	//카테고리 리스트
	@ResponseBody
	@RequestMapping(value="/categoryList", method= {RequestMethod.POST, RequestMethod.GET})
	public List<CategoryVo> categoryList(Model model, @PathVariable String id) {
		
		System.out.println("CategoryController > categoryList");
		
		return categoryService.categoryList(id);
		
	}
	
	//카테고리 추가
	@ResponseBody
	@RequestMapping(value="/categoryAdd", method= {RequestMethod.POST, RequestMethod.GET})
	public CategoryVo categoryAdd(@RequestBody CategoryVo categoryVo) {
		
		System.out.println("CategoryController > categoryAdd");
		
		return categoryService.categoryAdd(categoryVo);
		
	}
	
	//카테고리 삭제
	@ResponseBody
	@RequestMapping(value="/categoryDelete", method= {RequestMethod.POST, RequestMethod.GET})
	public String categoryDelete(@ModelAttribute CategoryVo categoryVo) {
		
		System.out.println("CategoryController->categoryDelete()");
		
		return categoryService.categoryDelete(categoryVo);
		
	}

}
