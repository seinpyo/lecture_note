package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ac.dao.MemberDao;
import com.ac.dto.MemberVO;

public class FindIdStep1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String url = "member/findIdForm.jsp";
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMemberByName(name, phone);
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		if(mvo == null) {
			//해당 이름이 없음
			request.setAttribute("msg", "해당하는 회원이 없습니다.");
		} else {
			request.setAttribute("memberVO", mvo);
			url = "member/findIdconfirmNumber.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
