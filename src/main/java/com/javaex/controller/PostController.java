package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PostService;
import com.javaex.vo.PostVo;

@Controller
@RequestMapping(value="/{id}/admin")
public class PostController {
	
	//필드
	@Autowired
	private PostService postService;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//글쓰기 폼
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(Model model, @PathVariable String id) {
		
		System.out.println("PostController > writeForm");
		
		//해더 이름 띄우기
		Map<String, Object> blogMap = postService.postList(id);
		model.addAttribute("blogMap", blogMap);
		
		return "blog/admin/blog-admin-write";
		
	}
	
	//글쓰기
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PostVo postVo, @PathVariable String id) {
		
		System.out.println("PostController > write");
		
		postService.write(postVo);
		
		return "redirect:/{id}/admin/writeForm";
	}

}
