package com.tms.entities;

import com.tms.id.TaskCategoryId;

import jakarta.persistence.EmbeddedId;
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
public class TaskCategory {

	@EmbeddedId
	private TaskCategoryId id;
	
	@ManyToOne
	@JoinColumn(name = "taskID", insertable=false, updatable=false)
	private Task task;
	
	@ManyToOne
	@JoinColumn(name = "categoryId", insertable=false, updatable=false)
	private Category category;
}
