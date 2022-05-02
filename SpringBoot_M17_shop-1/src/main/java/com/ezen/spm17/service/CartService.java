package com.ezen.spm17.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spm17.dao.ICartDao;

@Service
public class CartService {

	@Autowired
	ICartDao cdao;

	public void insertCart(HashMap<String, Object> paramMap) {
		cdao.insertCart(paramMap);
	}

	public void listCart(HashMap<String, Object> paramMap) {
		cdao.listCart(paramMap);
	}

	public void deleteCart(HashMap<String, Object> paramMap) {
		cdao.deleteCart(paramMap);
	}
	
	
	
}
