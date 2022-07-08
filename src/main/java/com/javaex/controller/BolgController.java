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
		
		//해더 이름 띄우기
		Map<String, Object> blogMap = blogService.main(id);
		model.addAttribute("blogMap", blogMap);
		
		return "blog/blog-main";
		
	}
	
	//내 블로그 관리
	@RequestMapping(value="/{id}/admin/basic", method={RequestMethod.GET, RequestMethod.POST})
	public String adminBasic(Model model, @PathVariable String id) {
		
		System.out.println("BolgController > adminBasic");

		//해더 이름 띄우기
		Map<String, Object> blogMap = blogService.main(id);
		model.addAttribute("blogMap", blogMap);
		
		return "blog/admin/blog-admin-basic";
		
	}
	
	//기본 설정 변경
	@RequestMapping(value="/{id}/admin/upload", method={RequestMethod.GET, RequestMethod.POST})
	public String upload(Model model, @PathVariable String id) {
		
		System.out.println("BolgController > upload");
		
		return "";
		
	}

}
