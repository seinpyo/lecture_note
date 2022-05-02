package student.service;

import student.dao.StudentDao;
import student.dto.Student;

public class UpdateService {
	private StudentDao sdao;
	
	public UpdateService (StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public void UpdateStudent(Student std) {
		sdao.updateStudent(std);
	}
}
