package com.tms.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tms.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

	@Query("select p from Project p where p.endDate > CURRENT_DATE")
	List<Project> projectsThatAreOngoing();
	
	@Query("SELECT p FROM Project p WHERE p.startDate >= :startDate AND p.endDate <= :endDate")
	List<Project> findProjectsInDateRange(
	            @Param("startDate") Date startDate,
	            @Param("endDate") Date endDate);
	}
