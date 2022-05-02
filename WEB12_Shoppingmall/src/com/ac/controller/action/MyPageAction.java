package com.ac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.dao.OrderDao;
import com.ac.dto.MemberVO;
import com.ac.dto.OrderVO;

public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  url ="mypage/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			url = "shop.do?command=loginForm";
		} else { 
			//order_view에서 id로 검색, result가 1(미처리)인 주문번호만 조회
			OrderDao odao = OrderDao.getInstance();
			ArrayList<OrderVO> finalList = new ArrayList<>(); //mypage.jsp에 전달될 리스트
			ArrayList<Integer> oseqList = odao.selectOSeqOrderIng(mvo.getId()); //주문번호 리스트(중복제거)
			for(Integer i : oseqList) System.out.println(i);
			for(Integer oseq : oseqList) {
				//주문번호 별로 상품을 조회 -> 총금액 계산 & 첫번째 상품(대표상품)을 저장함
				ArrayList<OrderVO> orderListByOseq = odao.listOrderByOseq(oseq);
				OrderVO ovo = orderListByOseq.get(0);
				ovo.setPname(ovo.getPname()+" 포함" + orderListByOseq.size() + "건");
				
				//총금액 계산
				int totalPrice=0;
				for(OrderVO ovo1 : orderListByOseq) 
					totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
				//총액변경
				ovo.setPrice2(totalPrice);
				finalList.add(ovo);
			}
			request.setAttribute("orderList", finalList);
			request.setAttribute("title", "진행 중인 주문 내역");
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
