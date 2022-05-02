package com.ezen.shop.controller;

import java.util.ArrayList;
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
	
	@RequestMapping("/orderOne")
	public String orderOne(HttpServletRequest request, 
			@RequestParam("pseq") int pseq, @RequestParam("quantity") int quantity) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		int oseq = 0;
		if(mvo == null) {
			return "member/login";
		} else {
			List<CartVO> cartList = cs.listCart(mvo.getUserid()); 
			oseq = os.insertOrderOne(pseq, quantity, mvo.getUserid());
		}
		
		return "redirect:/orderList?oseq=" + oseq;
	}
	
	@RequestsMapping("/myPage")
	public ModelAndView myPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			mav.setViewName("member/login");
		} else {
			ArrayList<OrderVO> orderList = new ArrayList<>(); //mypage.jsp에 전달될 리스트
			
			//1.아이디로 진행중인 주문의 주문번호를 조회 
			List<Integer> oseqList = os.selectSeqOrderIng(mvo.getUserid());
			
			//2. 조회한 주문번호를 상세 조회
			for(int oseq : oseqList) {
				List<OrderVO> orderListIng = oseqList.listOrderByOseq(oseq); 
				
				//3. 주문번호 목록에 "대표상품 외 x건" 으로 표시되도록 함
				OrderVO ovo = orderListIng.get(0);
				ovo.setPname(ovo.getPname() + "포함 "+ orderListIng.size() + "건");
				int totalPrice = 0;
				for(OrderVO ovo1 : orderListIng) totalPrice+=ovo1.getPrice2()*ovo1.getQuantity();
				ovo.setPrice2(totalPrice);
				
				//4. mypage.jsp에 전달할 리스트에 현재 ovo 추가
				orderList.add(ovo);
			}
			
			mav.addObject("title", "진행 중인 주문 내역");
			mav.addObject("orderList", orderList);
			mav.setViewName("mypage/mypage");
		}
		return mav; 
	}
	
	@RequestMapping("/orderAll") // 총 주문 내역
	public ModelAndView orderAll(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			mav.setViewName("member/login");
		} else {
			ArrayList<OrderVO> orderList = new ArrayList<>(); //mypage.jsp에 전달될 리스트
			List<Integer> oseqList = os.oseqListAll(mvo.getUserid());
			for(int oseq : oseqList) {
				List<OrderVO> orderListAll = os.listOrderByOseq(oseq);
				OrderVO ovo = orderListAll.get(0);
				ovo.setPname(ovo.getPname() + "포함 "+ orderListAll.size() + "건");
				int totalPrice = 0;
				for(OrderVO ovop : orderListAll) totalPrice += ovop.getQuantity();
				ovo.setPrice2(totalPrice);
				orderList.add(ovo);
			}
			mav.addObject("title", "총 주문 내역");
			mav.addObject("orderList", orderList);
			mav.setViewName("mypage/mypage");
		}
	}
	
	@RequestMapping("/orderDetail")
	public ModelAndView orderDetail(HttpServletRequest request,	@RequestParam("oseq") int oseq) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo == null) {
			mav.setViewName("member/login");
		} else {
			List<OrderVO> orderList = os.listOrderByOseq(oseq); 
			int totalPrice = 0;
			for(OrderVO ovo : orderList) totalPrice += ovo.getPrice2() * ovo.getQuantity();
			mav.addObject("oderList", orderList);
			mav.addObject("totalPrice", totalPrice);
			mav.setViewName("mypage/orderDetail");
			mav.addObject("orderDetail", orderList.get(0));
		}
		return mav;
	}
	
}
