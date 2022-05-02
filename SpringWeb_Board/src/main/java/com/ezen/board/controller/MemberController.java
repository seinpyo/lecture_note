package com.ezen.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.board.dto.MemberDto;
import com.ezen.board.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms; //함수안에 사용하지 않도록 주의
	
	@RequestMapping("/") 
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping("/login") 
	public String login(HttpServletRequest request) {
		//form의 input에 작성된 id, pwd가 전달됨 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDto mdto = ms.getMember(id);
		return "board/main";
	}
}
