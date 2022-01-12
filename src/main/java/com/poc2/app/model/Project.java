package com.poc2.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

@Entity
@Data
@Table(name ="projects")
public class Project {
	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projid;
	
	@NotNull
	@Size(max = 65)
	private String projname;
	
	@Temporal(TemporalType.DATE)
	private Date projduration;

}
