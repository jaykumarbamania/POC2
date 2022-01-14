package com.poc2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.app.model.Student;
//import com.poc2.app.repo.ProjectRepository;
import com.poc2.app.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
//	@Autowired
//	private ProjectRepository projectRepo;
	
	@PostMapping("/insert/student")
	public Student insertStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	
	@GetMapping("/getall")
	public List<Student> getAllStudent(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable int id) {
		return studentRepo.findById(id).get();
	}
	
}
