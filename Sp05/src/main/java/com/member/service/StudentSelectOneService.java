package com.member.service;

import com.member.dao.StudentDao;

public class StudentSelectOneService {
	private StudentDao sdao;
	public StudentSelectOneService(StudentDao sdao) {
		this.sdao = sdao;
	}
}
