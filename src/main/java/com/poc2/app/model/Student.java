package com.poc2.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="students")
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
	@Size(max = 15)
	private Long mobileno;
	
	@NotNull
	@Size(max = 65)
	@Column(unique = true)
	private String email;
	
	@OneToMany(targetEntity = Project.class,cascade = CascadeType.ALL)
	@JoinColumn(name="project_id", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Project> project;

}
