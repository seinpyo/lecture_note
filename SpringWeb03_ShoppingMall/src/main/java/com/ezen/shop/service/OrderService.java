package com.ezen.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.shop.dao.OrderDao;
import com.ezen.shop.dto.CartVO;
import com.ezen.shop.dto.OrderVO;

@Service
public class OrderService {
	
	@Autowired
	OrderDao odao;

	public int insertOrder(List<CartVO> cartList, String userid) {
		odao.insertOrders(userid); //orders 테이블에 레코드 추가
		
		int oseq = odao.lookupMaxOseq(); //현재 주문의 주문 번호 불러옴
		
		// 카트에 있는 각 상품들과 조회한 주문번호를 이용해서 order_detail테이블에 주문한 상품들을 추가
		for(CartVO cvo : cartList) {
			odao.insertOrderDetail(cvo, oseq); 
			odao.deleteCart(cvo.getCseq());
		}
		return oseq;
	}

	public List<OrderVO> listOrderByOseq(int oseq) {
		List<OrderVO> list = odao.listOrderBtOseq(oseq);
		return null;
	}

	public int insertOrderOne(int pseq, int quantity, String userid) {
		odao.insertOrders(userid);
		int oseq = odao.lookupMaxOseq();
		odao.insertOrderDetail(pseq, quantity, oseq);
		return 0;
	}

	public List<Integer> selectSeqOrderIng(String userid) {
		List<Integer> list = odao.selectSeqOrderIng(userid);
		
		return null;
	}
}
