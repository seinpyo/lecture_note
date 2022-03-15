package com.ezen.spg15.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.spg15.dao.IMemberDao;
import com.ezen.spg15.dto.MemberVO;
import com.ezen.spg15.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	
	@RequestMapping("/") 
	public String index() {
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result,
			HttpServletRequest request, Model model) {
		
		if(result.getFieldError("userid") != null) {
			model.addAttribute("message", result.getFieldError("userid").getDefaultMessage());
			return "member/loginForm";
		} else if(result.getFieldError("pwd") != null) {
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
			return "member/loginForm";
		}
		
		MemberVO mvo = ms.getMember(membervo.getUserid());
		
		if(mvo == null) {
			model.addAttribute("message", "아이디가 없습니다");
			return "member/loginForm";
		} else if (mvo.getPwd() == null) {
			model.addAttribute("message", "비밀번호 오류");
			return "member/loginForm";
		} else if(!mvo.getPwd().equals(membervo.getPwd())) {
			model.addAttribute("message", "비밀번호가 틀렸습니다");
			return "member/loginForm";
		} else if(mvo.getPwd().equals(membervo.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			return "redirect:/main";
		} else {
			model.addAttribute("message", "알수없는 오류");
			return "member/loginForm";
		}
	}
	

}
