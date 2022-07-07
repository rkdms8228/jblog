package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	//필드
	@Autowired
	private UserService userService;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//회원가입폼
	@RequestMapping(value="/joinForm", method={RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		
		System.out.println("UserController > joinForm");
		
		return "user/joinForm";
		
	}
	
	//회원가입
	@RequestMapping(value="/join", method={RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo, @ModelAttribute BlogVo blogVo) {
		
		System.out.println("UserController > join");
		
		userService.join(userVo, blogVo);
		
		System.out.println(userVo);
		
		return "user/joinSuccess";
		
	}
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/joinCheck", method={RequestMethod.GET, RequestMethod.POST})
	public String joinCheck(@ModelAttribute UserVo userVo) {
		
		System.out.println("UserController > joinCheck");
		
		String idCheck = userService.joinCheck(userVo.getId());
		
		return idCheck;
		
	}
	
	//로그인폼
	@RequestMapping(value="/loginForm", method={RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		
		System.out.println("UserController > loginForm");
		
		return "user/loginForm";
		
	}
	
	//로그인
	@RequestMapping(value="/login", method={RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		
		System.out.println("UserController > login");
		
		UserVo authUser = userService.login(userVo);
		
		/* 세션에 저장 */
		if(authUser != null) { //로그인 성공
			
			session.setAttribute("authUser", authUser);
			return "redirect:/";
			
		}else { //로그인 실패
			
			System.out.println("로그인 실패");
			return "redirect:loginForm?result=fail";
			
		}

	}
	
	//로그아웃
	@RequestMapping(value="/logout", method={RequestMethod.GET, RequestMethod.POST})
	public String logout(@ModelAttribute UserVo userVo, HttpSession session) {
		
		System.out.println("UserController > logout");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
		
	}

}
