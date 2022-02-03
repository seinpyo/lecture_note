package com.member.service;

import com.member.dao.StudentDao;

public class SpringContainerClass {
	
	private StudentDao sdao;
	private StudentSelectService ss;
	private StudentInsertService is;
	
	//생성자 -> 클래스 생성과 동시에 ss, is 객체 생성 
	public SpringContainerClass() {
		sdao = new StudentDao();
		ss = new StudentSelectService(sdao);
		is = new StudentInsertService(sdao);
	}
	
	//getter - getBean의 역할
	public StudentSelectService getSs() { 
		return ss;
	}
	public StudentInsertService getIs() {
		return is;
	}


	
}
