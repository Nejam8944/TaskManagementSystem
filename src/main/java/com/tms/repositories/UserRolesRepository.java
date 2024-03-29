package com.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer>{

}
