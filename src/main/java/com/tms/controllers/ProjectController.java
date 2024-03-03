package com.tms.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.entities.Project;
import com.tms.repositories.ProjectRepository;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	ProjectRepository repo;

	@GetMapping("/ongoing")
	public ResponseEntity<?> getOngoingProjects() {
		List<Project> projects = repo.projectsThatAreOngoing();
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}

	@GetMapping("/date-range/{startDate}/{endDate}")
	public List<Project> getProjectsInDateRange(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		return repo.findProjectsInDateRange(startDate, endDate);
	}

}
