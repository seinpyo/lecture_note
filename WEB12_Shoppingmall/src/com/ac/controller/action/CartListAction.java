package com.ac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.dao.CartDao;
import com.ac.dto.CartVO;
import com.ac.dto.MemberVO;

public class CartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/cartList.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url = "shop.do?command=loginForm";
		} else {
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> list = cdao.selectCart(mvo.getId());
			request.setAttribute("cartList", list); 
			//해당 아이디의 장바구니 리스트 
			
			int totalPrice=0;
			for(CartVO cvo : list) totalPrice += cvo.getPrice2()*cvo.getQuantity();
			
			request.setAttribute("totalPrice", totalPrice);
			//장바구니 상품들의 누적 금액
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
