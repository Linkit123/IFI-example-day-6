package com.linh.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linh.jpa.dao.StudentDAO;
import com.linh.jpa.model.Student;
@Service
public class StudentImpl implements StudentService{

	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public boolean studentExists(String studentName, String studentAddress) {
		return false;
	}

	@Override
	public Student findStudentById(int studentId) {
		return studentDAO.getOne(studentId);
	}

	@Override
	public List<Student> findAllStudent() {
		if(studentDAO.findAll().isEmpty()) {
			System.out.println("Danh sách sinh viên rỗng!");
			return studentDAO.findAll();
		}
		else {
			return studentDAO.findAll();
		}
	}

	@Override
	public void updateStudent(Student student) {
		
	}

	@Override
	public void deleteStudent(int studentId) {
			studentDAO.delete(studentId);
	}

	@Override
	public void addStudent(Student student) {
		studentDAO.save(student);
		System.out.println("Thêm sinh viên thành công!");
	}

//	@Override
//	public boolean checkStudent(int studentId) {
//		if(studentDAO.getOne(studentId)!=null )
//		return true;
//		else {
//			return false;
//		}
//	}

//	@Override
//	public Student findStudentByNameAndAddress(String studentName, String studentAddress) {
//		return studentDAO.;
//	}

}
