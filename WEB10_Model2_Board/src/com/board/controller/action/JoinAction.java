package com.board.controller.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.MemberDao;
import com.board.dto.MemberDto;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		MemberDto mdto = new MemberDto();
		mdto.setName(request.getParameter("name"));
		mdto.setUserid(request.getParameter("userid"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember(mdto);
		
//		if(result == 1) request.setAttribute("message", "회원가입이 완료되었습니다. 로그인 하세요.");
//		else request.setAttribute("message", "회원가입에 실패하였습니다. 관리자에게 문의하세요.");
//
//		RequestDispatcher dp = request.getRequestDispatcher("board.do?command=index");
//		dp.forward(request, response);
		
		String message = "";
		if(result==1) message = "회원가입에 성공하였습니다. 로그인하세요.";
		else message = "회원가입에 실패하였습니다. 관리자에게 문의하세요.";
		
		// forward 메서드로 이동한 도착 페이지에서 데이터도 한번 더 추가되려고 시도한다. 
		// (중복데이터가 계속 쌓이게됨)
		// 새로고침에 의해 포워딩 이전 코드가 다시 실행되지 않으려면 sendRedirect를 이용 
		
		response.sendRedirect("board.do?command=index&message=" + URLEncoder.encode(message, "UTF-8"));
		//sendRedirect("board.do?command=index&message=" + message) 만 작성한 경우 
		//한글이 깨져서 출력됨
	}
}
