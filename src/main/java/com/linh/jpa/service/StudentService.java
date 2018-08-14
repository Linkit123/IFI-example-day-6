package com.linh.jpa.service;

import java.util.List;

import com.linh.jpa.model.Student;

public interface StudentService {
	boolean studentExists(String studentName, String studentAddress);
	Student checkStudent(int studentId);
	Student findStudentById(int studentId);
	List<Student> findAllStudent();
	void updateStudent(Student student);
	void deleteStudent(int studentId);
	void addStudent(Student student);
//	 Student findStudentByNameAndAddress(String studentName,String studentAddress);
}
