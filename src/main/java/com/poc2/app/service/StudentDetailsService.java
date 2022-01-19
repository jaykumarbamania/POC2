package com.poc2.app.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poc2.app.model.Student;
import com.poc2.app.repo.StudentRepository;

@Service
@Transactional
public class StudentDetailsService implements UserDetailsService {
	
	@Autowired
	private StudentServiceImp studentService;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentService.getStudentByFirstName(username);
		System.out.println(student);
		if (student == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		

		return new org.springframework.security.core.userdetails.User(student.getFirstname(), student.getPassword(),
				new ArrayList<>());
	}
	
	public Student save(Student student) {
		Student newUser = student;
		newUser.setPassword(bcryptEncoder.encode(student.getPassword()));
		studentService.insertStudent(newUser);
		return newUser;
	}
}