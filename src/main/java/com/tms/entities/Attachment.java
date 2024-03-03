package com.tms.entities;

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
public class Attachment {

	@Id
	private int attachmentID;
	private String fileName;
	private String filePath;
	@ManyToOne
	@JoinColumn(name = "taskID")
	private Task task;
}
