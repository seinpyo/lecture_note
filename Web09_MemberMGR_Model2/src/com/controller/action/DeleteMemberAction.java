package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberDao;
import com.dto.MemberDto;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			MemberDto mdto = (MemberDto) session.getAttribute("loginUser");
			//Attribute에는 자료가 Object형으로 저장되기 때문에 형변환 필요
			//EL문법에서 형변환 하지 않는 이유는 EL문법에서 알아서 처리해주기 때문...
			
			MemberDao mdao = MemberDao.getInstance();
			mdao.deleteMember(mdto.getUserid());
			
			session.invalidate(); //세션에 있는 로그인 정보 지움
			
			request.setAttribute("message", mdto.getUserid() + " 회원탈퇴가 정상적으로 실행되었습니다.");
			RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
			dp.forward(request, response);
	}

}
