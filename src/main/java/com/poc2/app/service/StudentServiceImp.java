package com.poc2.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc2.app.model.Student;
import com.poc2.app.repo.StudentRepository;

@Service
public class StudentServiceImp implements StudentServices {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student insertStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Student getStudentByFirstName(String firstname) {
		return studentRepo.findByFirstname(firstname);
	}
	
	

}
