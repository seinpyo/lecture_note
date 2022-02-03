package com.member.service;

import com.member.dao.StudentDao;
import com.member.dto.Student;

public class StudentInsertService {
	
	private StudentDao sdao;
	
	StudentInsertService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public void insertStudent(Student std) {
		sdao.insertStudent(std);
	}
}
