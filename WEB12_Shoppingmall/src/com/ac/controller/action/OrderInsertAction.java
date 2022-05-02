package com.ac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.dao.CartDao;
import com.ac.dao.OrderDao;
import com.ac.dto.CartVO;
import com.ac.dto.MemberVO;

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url="";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			url = "shop.do?command=loginForm";
		} else {
			CartDao cdao = CartDao.getInstance();
			//주문자 id로 카트목록 먼저 조회
			ArrayList<CartVO> list = cdao.selectCart(mvo.getId());
			
			//카트목록과 주문자의 아이디로 orderDetail에 데이터 추가
			//추가한 주문의 주문번호를 리턴
			OrderDao odao = OrderDao.getInstance();
			int Oseq = odao.insertOrder(list,mvo.getId());
			
			//주문에 성공한 주문번호 -> 오더리스트로 이동, 주문번호로 주문내역을 다시 조회 
			// -> jsp로 이동
			url = "shop.do?command=orderList&oseq="+Oseq;
		}
		response.sendRedirect(url);
	}
}
