package com.ezen.spm17.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spm17.service.QnaService;

@Controller
public class QnaController {

	@Autowired
	QnaService qs;
	
//QnA list
	
	@RequestMapping("/qnaList")
	public ModelAndView qna_List(Model model, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	
	HttpSession session = request.getSession();
	HashMap<String, Object> loginUser = 
			(HashMap<String, Object>) session.getAttribute("loginUser");
	if(loginUser == null) {
		mav.setViewName("member/login");
	} else {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", loginUser.get("USERID"));
		paramMap.put("ref_cursor", null);
		qs.listQna(paramMap);
		
		ArrayList<HashMap<String, Object>> list
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		mav.addObject("qnaList", list);
		mav.setViewName("qna/qnaList");
	}
	return mav;
	}
}
