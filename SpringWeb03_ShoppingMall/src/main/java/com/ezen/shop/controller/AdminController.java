package com.ezen.shop.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.shop.service.AdminService;
import com.ezen.shop.service.ProductService;
import com.ezen.shop.service.QnaService;

@Controller
public class AdminController {
	@Autowired
	AdminService as;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	QnaService qs; 
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/admin")
	public String admi() {
		return "admin/adminLoginForm";
	}
	
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(HttpServletRequest request, @RequestParam("workId") String workId,
			@RequestParam("workPwd") String workPwd) {
		
		ModelAndView mav = new ModelAndView();
		
		int result = as.workerCheck(workId, workPwd);
		//-1:id 없음, 0:비번오류, 1:정상로그인
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("WorkId", workId);
			mav.setViewName("redirect:/productList");
		} else if(result == 0) {
			mav.addObject("message", "비밀번호를 확인하세요");
			mav.setViewName("admin/adminLoginForm");
		} else if (result == -1) {
			mav.addObject("message", "존재하지 않는 회원 아이디입니다.");
			mav.setViewName("admin/adminLoginForm");
		} else { 
			mav.addObject("message", "알 수 없는 오류. 관리자에게 문의하세요");
			mav.setViewName("admin/adminLoginForm");
		}
		return mav;
	} 
	
	@RequestMapping("productList")
	public String product_list(HttpServletRequest request) {
		return "admin/product/productList";
	}
}
