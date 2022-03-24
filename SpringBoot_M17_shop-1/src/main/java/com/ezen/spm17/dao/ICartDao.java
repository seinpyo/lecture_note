package com.ezen.spm17.dao;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spm17.dto.MemberVO;

@Mapper
public interface ICartDao {

	void insertCart(HashMap<String, Object> paramMap);
	void listCart(HashMap<String, Object> paramMap);
	void deleteCart(HashMap<String, Object> paramMap);
	
	
}
