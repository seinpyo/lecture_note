package com.ezen.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.board.dto.MemberDto;
import com.ezen.board.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;

	@RequestMapping(value="/", method=RequestMethod.GET)
	//프로젝트를 실행하면 보여질 페이지 
	public String firstRequest(HttpServletRequest request, Model model) {
		//session이 필요하기 때문에 전달인수로 HttpServletRequest를 받도록 함
		
		HttpSession session = request.getSession();
		String url = "";
		if(session.getAttribute("loginUser")!=null) {
			url = "redirect:/boardList";
		} else {
			url = "Member/loginForm";
		}
		
		return url;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		String url = "Member/loginForm";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDto mdto = ms.getMember(id); //id로 회원 조회 후 정보를 리턴 받음
		if(mdto == null) {
			model.addAttribute("message", "id를 조회할 수 없습니다.");	
		} else if (mdto.getPwd() == null) {
			model.addAttribute("message", "데이터베이스 오류. 관리자에게 문의하세요.");	
		} else if (mdto.getPwd().equals(pw)) {
			url = "redirect:/boardList";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
			
		} else if (!mdto.getPwd().equals(pw)) {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
		} else {
			model.addAttribute("message", "로그인 오류. 관리자에게 문의하세요.");
		}
		
		return url;
	}
	
	@RequestMapping(value="/memberJoinForm", method=RequestMethod.GET)
	public String memberJoinForm() {
		return "Member/memberJoinForm";
	}
	
	@RequestMapping("/idcheck") 
	public String idcheck(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		MemberDto mdto = ms.getMember(id);
		if (mdto == null) {
			model.addAttribute("result", -1);
		} else {
			model.addAttribute("result", 1);
		}
		model.addAttribute("id", id);
		return "Member/idcheck";
	}
	
	@RequestMapping (value="/memberJoin", method=RequestMethod.POST)
	public String memberJoin(HttpServletRequest request, Model model) {
		
		MemberDto mdto = new MemberDto();
		mdto.setEmail(request.getParameter("email"));
		mdto.setName(request.getParameter("name"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setPwd(request.getParameter("pw"));
		mdto.setUserid(request.getParameter("id"));
		
		int result = ms.insertMember(mdto);
		
		if (result==1) model.addAttribute("message", "회원가입이 완료되었습니다. 로그인 후 이용하세요!");
		else model.addAttribute("message", "회원가입 실패. 관리자에게 문의하세요!");
		
		return "Member/loginForm";
	}
	
	
	@RequestMapping("/memberEditForm")
	public String memberEditForm(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null) {
			return "Member/loginForm";
		}
		return "Member/memberEditForm";
	}
	
	@RequestMapping("/memberEdit") 
	public String memberEdit(HttpServletRequest request, Model model) {
		MemberDto mdto = new MemberDto();
		mdto.setUserid(request.getParameter("id"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setName(request.getParameter("name"));
		
		int result = ms.updateMember(mdto);
		
		HttpSession session = request.getSession();
		if(result==1) session.setAttribute("loginUser", mdto);
		
		return "redirect:/boardList";
	}
	
	@RequestMapping("/logout") 
	public String logout(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
