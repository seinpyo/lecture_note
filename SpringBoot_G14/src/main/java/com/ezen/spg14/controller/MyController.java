package com.ezen.spg14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg14.service.MyService;

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
	
		model.addAttribute("id", id);
		model.addAttribute("amount", amount);
		
		if(result == 1) return "buy_ticket_end";
		else return "buy_ticket_error";
		
	}
}
