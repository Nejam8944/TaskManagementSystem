package com.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.TaskCategory;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Integer>{

}
