package com.ac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.controller.action.Action;
import com.ac.dao.AdminDao;
import com.ac.dto.AdminVO;

public class AdminLoginaction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String workId = request.getParameter("workId");
		String workPwd = request.getParameter("workPwd");
		
		String url = "shop.do?command=admin";
		
		AdminDao adao = AdminDao.getInstance();
		AdminVO avo = adao.workerCheck(workId);
		//String pwd = adao.workerCheck(workId); 
		//AdminVO는 로그인 할 때를 제외하고는 사용하지 않으므로 dto를 생성하지않고
		//String 변수로 처리해도 무방
		
		if(avo==null) request.setAttribute("msg", "존재하지 않는 관리자 아이디 입니다.");
		else if(avo.getPwd() == null) request.setAttribute("msg", "DB오류. 관리자에게 문의하세요.");
		else if(!avo.getPwd().equals(workPwd)) request.setAttribute("msg", "비밀번호가 일치하지 않습니다");
		else {
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", avo);
			url = "shop.do?command=adminProductList";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
