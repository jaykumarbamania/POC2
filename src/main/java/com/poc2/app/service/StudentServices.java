package com.poc2.app.service;

import java.util.List;

import com.poc2.app.model.Student;

public interface StudentServices {
	
	List<Student> getAllStudents();
	
	Student insertStudent(Student student);
	
	Student getStudentById(int id);
	
	Student getStudentByFirstName(String firstname);
	
}
