package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.dto.MemberVO;

public class EditFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		String addr = mvo.getAddress();
		
		//주소형식 ex: 서울시 마포구 대현동 115-1
		int k1 = addr.indexOf(" "); // 첫번째 공백 위치 찾음
		int k2 = addr.indexOf(" ", k1+1); //k1부터 그다음 공백 위치
		int k3 = addr.indexOf(" ", k2+1); //k2부터 그다음 공백 위치
		
		//k3 : 세번째 공백의 인덱스 값 = 11
		
		String addr1 = addr.substring(0, k3);
		String addr2 = addr.substring(k3+1);
		
		request.setAttribute("addr1", addr1);
		request.setAttribute("addr2", addr2);
		
		RequestDispatcher dp = request.getRequestDispatcher("member/updateForm.jsp");
		dp.forward(request, response);
	}
}
