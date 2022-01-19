package com.poc2.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc2.app.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
