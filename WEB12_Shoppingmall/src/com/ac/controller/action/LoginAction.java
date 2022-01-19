package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.dao.MemberDao;
import com.ac.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);

		
		 if(mvo == null) { 
			 request.setAttribute("message", "존재하지 않는 회원입니다."); 
		 } else if (mvo.getPwd()==null) { 
			 request.setAttribute("message", "회원정보 오류. 관리자에게 문의하세요"); 
		 } else if (!mvo.getPwd().equals(pwd)) {
			 request.setAttribute("message", "비밀번호가 일치하지 않습니다."); 
		 } else if(mvo.getPwd().equals(pwd)) { 
			 HttpSession session = request.getSession(); 
			 session.setAttribute("loginUser", mvo);
			 url="shop.do?command=index"; 
		 } else {
			 request.setAttribute("message", "로그인이 실패하였습니다. 관리자에게 문의하세요"); 
		 }
		

		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}
}
