package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;

@Controller
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
	@RequestMapping(value="/{id}/admin/category", method={RequestMethod.GET, RequestMethod.POST})
	public String category(Model model, @PathVariable String id) {
		
		System.out.println("CategoryController > category");
		
		//해더 이름 띄우기
		Map<String, Object> blogMap = blogService.main(id);
		model.addAttribute("blogMap", blogMap);
		
		return "blog/admin/blog-admin-cate";
		
	}

}
