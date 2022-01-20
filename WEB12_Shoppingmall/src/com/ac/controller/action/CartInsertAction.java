package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.dao.CartDao;
import com.ac.dto.CartVO;
import com.ac.dto.MemberVO;

public class CartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url = "";
		if(mvo == null) {
			url = "shop.do?command=loginForm";
		} else {
			//로그인 중인 아이디, 전달된 파라미터의 수량과 상품번호를 CartVO에 넣고 insert
			CartVO cvo = new CartVO();
			cvo.setId(mvo.getId());
			cvo.setPseq(Integer.parseInt(request.getParameter("pseq")));
			cvo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			CartDao cdao = CartDao.getInstance();
			cdao.insertCart(cvo);
			url = "shop.do?command=cartList";
		}
		//insert 후, 카트리스트를 조회(cart_view)해서 cartList.jsp로 이동
		
		response.sendRedirect(url);
	}
}
