package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JoinFormAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "member/joinForm.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			url = "member.do?command=main"; 
			//관리자인지 일반회원인지 확인하여 main으로 보내기 위함
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}
}
