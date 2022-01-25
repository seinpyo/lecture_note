package com.ac.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ac.controller.action.Action;
import com.ac.dao.AdminDao;
import com.ac.dto.AdminVO;
import com.ac.dto.ProductVO;
import com.ac.util.Paging;

public class AdminProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "admin/product/productList.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("loginAdmin");
		if(avo==null) url = "shop.do?command=admin";
		else {
			
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if (session.getAttribute("page")!=null) {
				page = (int) session.getAttribute("page");
			} else {
				page = 1;
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			AdminDao adao = AdminDao.getInstance();
			
			String key="";
			if(request.getParameter("key")!=null) {
				key = request.getParameter("key");
				session.setAttribute("key",key);
			} else if(session.getAttribute("key")!=null) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
				key="";
			}
			
			int count = adao.getAllCount("product", "name", key); //총게시물 수 얻어오기 
			//product:테이블명, name:필드명
			paging.setTotalCount(count); //실행 시 paging() 메소드도 함께 실행됨
			request.setAttribute("paging", paging);
			
			ArrayList<ProductVO> productList = adao.listProduct(paging, key); 
			request.setAttribute("productList", productList);
			request.setAttribute("key", key);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
