package com.member.main;

import java.util.ArrayList;

import com.member.dto.Student;
import com.member.service.SpringContainerClass;
import com.member.service.StudentInsertService;
import com.member.service.StudentSelectService;

public class Main {
	public static void main(String[] args) {
		
		SpringContainerClass scc = new SpringContainerClass();
		
		StudentInsertService sis  = scc.getIs();
//		Student std = new Student("a1234", "hippo", "98765", "barbara", 27, "W", "Korean Literature");
//		sis.insertStudent(std);
//		Student std = new Student("b1234", "raccoon", "15284", "chris", 20, "W", "Franch Literature");
//		sis.insertStudent(std);

		StudentSelectService sss = scc.getSs();
		ArrayList<Student> list = sss.selectStudent();
		
		for(int i=0; i<list.size(); i++) {
			System.out.print("|sNum : " + list.get(i).getsNum() + "\t");
			System.out.print("|sId : " + list.get(i).getsId() + "\t");
			System.out.print("|sPw : " + list.get(i).getsPw() + "\t");
			System.out.print("|sName : " + list.get(i).getsName() + "\t");
			System.out.print("|sAge : " + list.get(i).getsAge() + "\t");
			System.out.print("|sGender : " + list.get(i).getsGender() + "\t");
			System.out.print("|sMajor : " + list.get(i).getsMajor() + "\t");
			System.out.println();
		}
		
	}
}
