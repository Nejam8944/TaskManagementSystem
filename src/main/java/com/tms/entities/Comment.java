package com.tms.entities;

import java.time.LocalDateTime;

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
public class Comment {

	@Id
	private int commentID;
	private String text;
	private LocalDateTime createdAt;
	@ManyToOne
	@JoinColumn(name = "taskID")
	private Task task;
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
}
