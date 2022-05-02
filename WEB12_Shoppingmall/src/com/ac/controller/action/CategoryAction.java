package com.ac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ac.dao.ProductDao;
import com.ac.dto.ProductVO;

public class CategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind");
		ProductDao pdao = ProductDao.getInstance(); 
		ArrayList<ProductVO> list  = pdao.selectKindProduct(kind);
		request.setAttribute("productKindList", list);
		String url = "product/productKind.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
