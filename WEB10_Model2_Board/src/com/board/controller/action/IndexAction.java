package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "member/loginForm.jsp";
		HttpSession session = request.getSession();
		
		request.setAttribute("message", request.getParameter("message"));
		//request로 받은 파라미터를 다시 request에 넣어 그대로 전달
		
		if(session.getAttribute("loginUser")!=null) url = "board.do?command=main";
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
