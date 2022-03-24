package com.ezen.spm17.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spm17.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService os;
	
	@RequestMapping("/orderInsert")
	public String orderInsert(HttpServletRequest request) {
		
		int oseq = 0;
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "member/login";
		} else {
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("id", loginUser.get("USERID"));
			paramMap.put("oseq", 0);
			
			os.insertOrder(paramMap);
			//아이디로 카트검색
			//검색 내용으로 orders, order_detail 테이블에 레코드 추가
			//oseq에 주문번호를 가지고 돌아옴
			
			oseq = Integer.parseInt(paramMap.get("oseq").toString());
			System.out.println(oseq);
		}
		
		return "redirect:/orderList?oseq="+oseq;
	}
	
	@RequestMapping("/orderList")
	public ModelAndView orderList(@RequestParam("oseq") int oseq, HttpServletRequest request,
			Model model) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			mav.setViewName("member/login");
		} else {
			HashMap<String, Object> paramMap = new HashMap<String, Object> ();
			paramMap.put("oseq", oseq);
			paramMap.put("ref_cursor", null);
			
			os.listOrderByOseq(paramMap);
			ArrayList<HashMap<String, Object>> list
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			mav.addObject("orderList", list);
			
			int totalPrice = 0;
			for (HashMap<String, Object> ovo : list) {
				totalPrice += Integer.parseInt(ovo.get("QUANTITY").toString()) 
						*Integer.parseInt(ovo.get("PRICE2").toString());
			}
			mav.addObject("totalPrice", totalPrice);
			mav.setViewName("mypage/orderList");
		}
		
		return mav;
	}
}
