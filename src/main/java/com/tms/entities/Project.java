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
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	@Id
	private int projectID;
	private String projectName;
	private String description;
	private Date startDate;
	private Date endDate;
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
}
