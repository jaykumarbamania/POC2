package com.poc2.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc2.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
