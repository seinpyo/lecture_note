package com.word;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.word.dto.WordSet;
import com.word.service.WordInsertService;
import com.word.service.WordSearchService;

public class MainClass {

	public static void main(String[] args) {

		String[] keyWords = {"c","c++","java","jsp","spring"};
		
		String[] values = {
			"C는 1972년 켄 톰슨과 데니스 리치가 유닉스 운영 체제에서 사용하기 위해 개발 했다.",
			"C++은 AT&T 벨 연구소의 비야네 스트롭스트룹이 1983년 발표하여 발전한 저쩌구",
			"자바는 썬 마이크로시스템즈의 제임스 고슬링과 다른 연구원들이 개발한 ~~",
			"JSP는 HTML내에 자바 코드를 삽입하여 웹 서버에 동적으로 웹 페이지를 생성 어쩌구",
			"스프링 프레임워크는 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임 워크 웅앵"
		};
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		WordInsertService wis = ctx.getBean("registerService", WordInsertService.class);
		
		for(int i=0; i<values.length; i++) {
			WordSet wordSet = new WordSet(keyWords[i], values[i]);
			wis.insert(wordSet);
		}
		
		WordSearchService ss = ctx.getBean("searchService", WordSearchService.class);
		WordSet ws = ss.searchWord("c");
		if(ws == null) {
			System.out.println("검색 결과가 존재하지 않습니다");
		}
		System.out.println("\n\n-------------------------------------");
		System.out.print(ws.getWordKey() + "\t");
		System.out.println(ws.getWordValue());
		System.out.println("---------------------------------------");
	} 
}
