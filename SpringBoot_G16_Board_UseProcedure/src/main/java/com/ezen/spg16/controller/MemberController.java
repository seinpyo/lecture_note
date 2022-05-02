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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("memberJoinForm")
	public String join_form() {
		return "member/memberJoinForm";
	}
	
	
	@RequestMapping("/idcheck")
	public ModelAndView idcheck(@RequestParam("userid") String userid) {
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("userid", userid);
		paramMap.put("ref_cursor", null);
		ms.getMember(paramMap);
		ArrayList<HashMap<String, Object>> list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		
		if(list.size() == 0) mav.addObject("result", -1);
		else mav.addObject("result", 1);
		
		mav.addObject("userid", userid);
		mav.setViewName("member/idcheck");
		
		return mav;
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST) 
	public ModelAndView memberJoin(@ModelAttribute("dto") @Valid MemberVO membervo, 
			BindingResult result,
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
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userid", membervo.getUserid());
			paramMap.put("pwd", membervo.getPwd());
			paramMap.put("name", membervo.getName());
			paramMap.put("email", membervo.getEmail());
			paramMap.put("phone", membervo.getPhone());
			ms.insertMember(paramMap);
			
			mav.addObject("message", "회원 가입이 완료되었습니다");
			mav.setViewName("member/loginForm");
		}
		
		return mav;
	}
	
	@RequestMapping("/memberEditForm")
	public ModelAndView mem_edit_form(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> loginUser 
			= (HashMap<String, Object>) session.getAttribute("loginUser");
		MemberVO dto = new MemberVO();
		dto.setUserid((String)loginUser.get("USERID"));
		dto.setPwd((String)loginUser.get("PWD"));
		dto.setEmail((String)loginUser.get("EMAIL"));
		dto.setPhone((String)loginUser.get("PHONE"));
		dto.setName((String)loginUser.get("NAME"));
		
		mav.addObject("dto", dto);
		mav.setViewName("member/memberEditForm");
		return mav;
	}
	
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
			HashMap<String, Object> mvo = new HashMap<>();
			mvo.put("USERID", membervo.getUserid());
			mvo.put("PWD", membervo.getPwd());
			mvo.put("NAME", membervo.getName());
			mvo.put("PHONE", membervo.getPhone());
			mvo.put("EMAIL", membervo.getEmail());
			ms.updateMember(mvo);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			url = "redirect:/main";
		}
		return url;
	}
	
}
