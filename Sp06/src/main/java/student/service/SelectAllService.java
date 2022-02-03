package student.service;

import java.util.ArrayList;

import student.dao.StudentDao;
import student.dto.Student;

public class SelectAllService {
	private StudentDao sdao;
	public SelectAllService(StudentDao sdao) {
		this.sdao = sdao;
	}
	public ArrayList<Student> selectAllStudent(){
		ArrayList<Student> list = null;
		list = sdao.selectAllStudnet();
		return list;
	}

}
