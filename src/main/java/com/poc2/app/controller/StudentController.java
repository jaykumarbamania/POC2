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
import com.poc2.app.service.StudentServiceImp;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImp studentService;
	
//	@Autowired
//	private ProjectRepository projectRepo;
	

	
	@GetMapping("/getall")
	public List<Student> getAllStudent(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
}
