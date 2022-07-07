package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;

@Controller
public class BolgController {
	
	//필드
	@Autowired
	private BlogService blogService;
		
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//블로그 메인화면
	@RequestMapping(value="/{id}", method={RequestMethod.GET, RequestMethod.POST})
	public String blogMain(Model model, @PathVariable String id) {
		
		System.out.println("BolgController > blogMain");
		
		Map<String, Object> blogMap = blogService.main(id);
		model.addAttribute("blogMap", blogMap);
		
		return "blog/blog-main";
		
	}

}