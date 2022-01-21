package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.dao.OrderDao;
import com.ac.dao.ProductDao;
import com.ac.dto.MemberVO;
import com.ac.dto.ProductVO;

public class OrderOneAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		if(mvo == null) {
			url = "shop.do?command=index";
		} else { 
			String id = mvo.getId();
			ProductDao pdao = ProductDao.getInstance();
			ProductVO pvo = pdao.getProduct(pseq);
			OrderDao odao = OrderDao.getInstance();
			int oseq = odao.insertOrderOne(pvo, id, quantity);
			url = "shop.do?command=orderList&oseq="+oseq;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
