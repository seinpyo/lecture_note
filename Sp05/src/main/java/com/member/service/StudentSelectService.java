package com.member.service;

import java.util.ArrayList;

import com.member.dao.StudentDao;
import com.member.dto.Student;

public class StudentSelectService {
	private StudentDao sdao;
	
	StudentSelectService(StudentDao sdao){
		this.sdao = sdao;
	}
	
	public ArrayList<Student> selectStudent() {
		ArrayList<Student> list = sdao.selectStudent();
		return list;
	}
}
