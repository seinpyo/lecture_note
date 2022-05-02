package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberDao;
import com.dto.MemberDto;

public class LoginAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid); 
		//아이디 비밀번호가 일치하는지 확인하기 위해 정보 가져오기 
		
		String url = "member/loginForm.jsp";
				//로그인이 실패하게될 경우 로그인폼으로 돌아감
		if(mdto==null) {
			request.setAttribute("message", "존재하지 않는 회원 아이디입니다.");
		} else if(mdto.getPwd() == null) {
			request.setAttribute("message", "비밀번호 오류. 관리자에게 문의하세요.");
		} else if (!mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
		} else if (mdto.getPwd().equals(pwd)) {
			 url = "member.do?command=main"; //로그인이 성공하면 main.jsp로 이동
			 HttpSession session = request.getSession();
			 session.setAttribute("loginUser", mdto);
			 //세션에 로그인한 사용자 정보를 "loginUser"라는 이름으로 저장
		} else {
			request.setAttribute("message", "로그인 오류. 관리자에게 문의하세요");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		
	}
}
