package student.service;

import student.dao.StudentDao;
import student.dto.Student;

public class SelectOneService {
	private StudentDao sdao;
	
	public SelectOneService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public Student selectOneStudent(String sId) {
		Student std = null;
		std = sdao.selectOneStudent(sId);
		return std;
	}
}
