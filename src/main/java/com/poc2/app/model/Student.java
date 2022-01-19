package com.poc2.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="students")
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 65)
	private String firstname;
	
	@NotNull
	@Size(max = 65)
	private String lastname;
	
	@NotNull
	private Long mobileno;
	
	@NotNull
	@Size(max = 65)
	private String password;
	
	@NotNull
	@Size(max = 65)
	@Column(unique = true)
	private String email;
	
	@OneToMany(targetEntity = Project.class,cascade = CascadeType.ALL)
	@JoinColumn(name="fk_stuid", referencedColumnName = "id")
	private List<Project> projects;

}
