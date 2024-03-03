package com.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
