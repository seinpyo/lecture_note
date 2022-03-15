package com.ezen.spg15.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg15.dto.Paging;
import com.ezen.spg15.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/main") 
	public ModelAndView goMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();

		//로그인 체크		
		if(session.getAttribute("loginUser") == null) 
			mav.setViewName("member/loginForm");
		else {
			//페이지체크
			int page = 1; 
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if(session.getAttribute("page") != null) {
				page = (int) session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
		
			Paging paging = new Paging();
			paging.setPage(page);
			int count = bs.getAllCount();
			paging.setTotalCount(count);
			paging.paging(); 
			//setter에 의한 자동 실행이 불가(롬복으로 setter를 만들어서)하므로 수동으로 실행
			
			mav.addObject("boardList", bs.selectBoardAll(paging));
			mav.addObject("paging", paging);
			mav.setViewName("board/main");
		} 

		return mav;
	} 
}
