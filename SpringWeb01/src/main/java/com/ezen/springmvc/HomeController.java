package com.ezen.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

//서버에 요청되는 리퀘스트들을 다루는 클래스
//클래스 이름 위에 @Controller - 어노테이션을 표시하면 그 안에 사용되는 @RequestMapping에서 리퀘스트가 검색, 선택, 실행된다. 
//첫페이지의 주소 http://localhost:8090/springmvc/ 는 localhost의 8090 포트 중 springmvc로 대표되는 프로젝트에 요청을 보낸 상태이고 
//요청 키워드는 '/' 이다 -> 클래스 안에 있는 메서드 중 @RequestMapping('/')을 찾아 실행하고 리턴한다. 

@Controller
public class HomeController {
	
	//@Autowired
	//HomeDao hdao;
	//직접 DAO에 접근하지 못하도록 함
	
	@Autowired 
	HomeService hs;
	
	//log 출력을 위한 준비
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//method=RequestMethod.GET은 생략 가능, POST 는 반드시 기재할 것
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/main") 
	public String main() {
		return "main";
		
	}
	
	@RequestMapping("/other")
	public String ohter(Model model) {
		
		//String message = hdao.getMessage();
		String message = hs.getMessage();
		
		model.addAttribute("message", message);
		return "other";
	}
	
}
