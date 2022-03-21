package com.ezen.spg16.controller;

import java.util.ArrayList;
import java.util.HashMap;

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

import com.ezen.spg16.dto.MemberVO;
import com.ezen.spg16.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ms;
	
	
	@RequestMapping("/") 
	public String index(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null)
			return "member/loginForm";
		else
			return "redirect:/main";
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
		

		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("userid", membervo.getUserid());
		paramMap.put("ref_cursor", null);
		
		ms.getMember(paramMap);
		//프로시저에서 한 개 이상의 레코드들이 커서를 통해 전달될 때 List 형태로 전달 됨
		
		//1. 리스트 put
		ArrayList<HashMap<String, Object>> list = 
				(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		//프로시저의 결과는 해쉬맵 형태로 저장 됨
		//해쉬맵 하나 = 레코드 하나(필드명과 값) -> 이들의 집합이 ref_cursor라는 키에 저장된 것
		
		//2. 첫번째 항목을 mvo에 담기
		HashMap<String, Object> mvo = list.get(0);
		//필드명은 대문자로 적을 것
		
		//3. 리스트의 결과가 아무것도 없는지 먼저 확인
		if(list.size() == 0) {
			model.addAttribute("message", "아이디가 없습니다.");
			return "member/loginForm";
		}
		
		
		if (mvo.get("PWD") == null) {
			model.addAttribute("message", "비밀번호 오류");
			return "member/loginForm";
		} else if(!mvo.get("PWD").equals(membervo.getPwd())) {
			model.addAttribute("message", "비밀번호가 틀렸습니다");
			return "member/loginForm";
		} else if(mvo.get("PWD").equals(membervo.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			return "redirect:/main";
		} else {
			model.addAttribute("message", "알수없는 오류");
			return "member/loginForm";
		}
	}
}
