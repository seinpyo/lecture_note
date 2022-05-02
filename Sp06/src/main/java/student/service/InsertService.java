package student.service;

import student.dao.StudentDao;
import student.dto.Student;

public class InsertService {
	
	private StudentDao sdao;
	
	public InsertService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public void InsertStudent(Student std) {
		sdao.insertStudent(std);
	}
}
