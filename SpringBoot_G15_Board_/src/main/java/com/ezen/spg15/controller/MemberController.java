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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
//회원가입
	
	//폼으로 이동
	@RequestMapping("/memberJoinForm")
	public String join_form() {
		return "member/memberJoinForm";
	}
	
	//아이디 중복확인
	@RequestMapping("/idcheck")
	public ModelAndView idcheck(@RequestParam("userid") String userid) {
		
		ModelAndView mav = new ModelAndView();
		MemberVO mvo = ms.getMember(userid);
		if(mvo == null) mav.addObject("result", -1);
		else mav.addObject("result", 1);
		
		mav.addObject("userid", userid);
		mav.setViewName("member/idcheck");
		
		return mav;
	}
	
	//validation 후 insertMember
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST) 
	public ModelAndView memberJoin(@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result,
			Model model, @RequestParam("re_id") String re_id,
			@RequestParam("pw_check") String pw_check) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberJoinForm");
		if(re_id != null || re_id.equals("") || !re_id.equals(membervo.getUserid())) 
			 mav.addObject("re_id", re_id);
		
		if(result.getFieldError("userid") != null) 
			mav.addObject("message", result.getFieldError("userid").getDefaultMessage());
		 else if(result.getFieldError("pwd") != null) 
			 mav.addObject("message", "비밀번호를 입력하세요");
		 else if(result.getFieldError("name") != null) 
			 mav.addObject("message", "이름을 입력하세요");
		 else if(result.getFieldError("email") != null) 
			 mav.addObject("message", "이메일을 입력하세요");
		 else if(result.getFieldError("phone") != null) 
			 mav.addObject("message", "전화번호를 입력하세요");
		 else if(!pw_check.equals(membervo.getPwd())) 
			 mav.addObject("message", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		 else if (!membervo.getUserid().equals(re_id)) 
			 mav.addObject("message", "아이디 중복체크를 해주세요");
		 else {
			ms.insertMember(membervo);
			mav.addObject("message", "회원 가입이 완료되었습니다");
			mav.setViewName("member/loginForm");
		}
		
		return mav;
	}

//회원 정보 수정
	@RequestMapping("/memberEditForm")
	public ModelAndView mem_edit_form(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		MemberVO dto = (MemberVO) session.getAttribute("loginUser");
		mav.addObject("dto", dto);
		mav.setViewName("member/memberEditForm");
		//loginUser을 MemberVO dto 형태로 form 에 전달
		
		return mav;
	}
	
	//validation 후 update
	@RequestMapping("memberEdit")
	public String memberEdit(@ModelAttribute("dto") @Valid MemberVO membervo, 
			BindingResult result, @RequestParam("pw_check") String pw_check, Model model,
			HttpServletRequest request) {
		
		String url = "member/memberEditForm";
		
		if(result.getFieldError("pwd") != null) 
			 model.addAttribute("message", "비밀번호를 입력하세요");
		 else if(result.getFieldError("name") != null) 
			 model.addAttribute("message", "이름을 입력하세요");
		 else if(result.getFieldError("email") != null) 
			 model.addAttribute("message", "이메일 입력하세요");
		 else if(result.getFieldError("phone") != null) 
			 model.addAttribute("message", "전화번호를 입력하세요");
		 else if(!pw_check.equals(membervo.getPwd())) 
			 model.addAttribute("message", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		 else {
			ms.updateMember(membervo);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", membervo);
			url = "redirect:/main";
		}
		return url;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
