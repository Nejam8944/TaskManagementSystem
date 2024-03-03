package com.tms.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	@Id
	private int taskID;
	private String taskName;
	private String description;
	private Date dueDate;
	private String priority;
	private String status;
	@ManyToOne
	@JoinColumn(name = "projectID")
	private Project project;
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
	
}
