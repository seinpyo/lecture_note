package com.ezen.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.shop.dto.CartVO;
import com.ezen.shop.dto.MemberVO;
import com.ezen.shop.dto.OrderVO;
import com.ezen.shop.service.CartService;
import com.ezen.shop.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService os;
	
	@Autowired
	CartService cs; //카트의 정보를 가져와야하므로
	
	@RequestMapping("/orderInsert")
	public String orderInsert(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int oseq = 0;
		
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			return "member/login";
		} else {
			List<CartVO> cartList = cs.listCart(mvo.getUserid()); 
			oseq = os.insertOrder(cartList, mvo.getUserid());
		}
		
		//방금 주문한 주문번호로 리스트 조회후 화면에 표시하러 이동
		return "redirect:/orderList?oseq="+oseq;
	}
	
	@RequestMapping("/orderList")
	public ModelAndView orderList(@RequestParam("oseq") int oseq, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView();
		if(mvo == null) {
			mav.setViewName("member/login");
		} else {
			List<OrderVO> list = os.listOrderByOseq(oseq);
			int totalPrice = 0;
			for (OrderVO ovo : list) {
				totalPrice = ovo.getPrice2() * ovo.getQuantity();
			}
			mav.addObject("orderList", list);
		}
		
		return mav;
	}
	
	
}
