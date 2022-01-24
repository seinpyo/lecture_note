package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ac.dao.MemberDao;
import com.ac.dto.MemberVO;

public class FindPwStep1Action implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String url = "member/findPwForm.jsp";
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		if(mvo == null) {
			request.setAttribute("msg", "일치하는 회원이 존재하지 않습니다.");
		} else if( (!name.equals(mvo.getName())) || (!phone.equals(mvo.getPhone())) ) {
			request.setAttribute("msg", "id와 회원 정보가 일치하지 않습니다.");
		} else {
			request.setAttribute("member", mvo);
			url = "member/findPwconfirmNumber.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
