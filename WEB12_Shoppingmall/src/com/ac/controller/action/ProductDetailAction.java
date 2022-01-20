package com.ac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ac.dao.ProductDao;
import com.ac.dto.ProductVO;

public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		ProductDao mdao = ProductDao.getInstance();
		ProductVO mvo = mdao.getProduct(pseq);
		
		request.setAttribute("productVO", mvo);
		
		String url = "product/productDetail.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
