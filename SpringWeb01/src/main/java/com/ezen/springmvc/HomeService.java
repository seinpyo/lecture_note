package com.ezen.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	@Autowired
	HomeDao hdao;
	
	public String getMessage() {
		String message = hdao.getMessage();
		return message;
	}
}
