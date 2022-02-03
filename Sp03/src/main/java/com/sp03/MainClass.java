package com.sp03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		//일반적인 클래스의 객체 생성 및 사용 예
		WalkClass wc = new WalkClass();
		wc.move();
		
		//스프링 컨테이너에 담겨 있는 객체들을 Bean이라 하며 
		//bean 을 꺼내 쓰려면 컨테이너 사용 권한을 갖고 있는 객체를 생성하여 사용한다.
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		WalkClass wc2 = ctx.getBean("cWalk", WalkClass.class);
		//cWalk : 스프링 컨테이너 내부에 있는 클래스의 id값
		//WalkClass.classl 스프링 컨테이너 내부에 있는 해당 클래스의 이름
		wc2.move();
		ctx.close();
	}
}
