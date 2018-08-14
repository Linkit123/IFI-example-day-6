package com.linh.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linh.jpa.model.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{
	
}
