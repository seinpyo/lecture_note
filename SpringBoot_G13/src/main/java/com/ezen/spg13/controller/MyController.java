package com.ezen.spg13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg13.service.MyService;

@Controller
public class MyController {

	@Autowired 
	MyService ms;
	
	@RequestMapping("/")
	public String root() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buyTicketCard")
	public String buy_ticket_card(Model model, @RequestParam("id") String id,
			@RequestParam("amount") int amount, @RequestParam("error") int error) {
		
		int result = ms.buy(id, amount, error);
		//전달 된 아이디, 구매갯수, 에러 여부를 서비스단에 전달하여 구매작업 실행
		//성공 실패에 따라 해당 페이지로 이동하게 함
		
		model.addAttribute("id", id);
		model.addAttribute("amount", amount);
		
		if(result == 1) return "buy_ticket_end";
		else return "buy_ticket_error";
		
		
	}
}
