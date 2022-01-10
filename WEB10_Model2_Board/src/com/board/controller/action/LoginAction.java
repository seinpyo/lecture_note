package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.MemberDao;
import com.board.dto.MemberDto;

public class LoginAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);

		String url = "member/loginForm.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("loginuser")!=null) url="board.do?command=main";
		
		if (mdto == null) {
			request.setAttribute("message", "존재하지 않는 회원 아이디 입니다.");
		} else if(mdto.getPwd() == null) {
			request.setAttribute("message", "비밀번호 오류. 관리자에게 문의하세요.");
		} else if(!mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
		} else if (mdto.getPwd().equals(pwd)) {
			session.setAttribute("loginUser",mdto);
			url = "board.do?command=main";
		} else {
			request.setAttribute("message", "로그인 오류. 관리자에게 문의하세요.");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		
	}
}
