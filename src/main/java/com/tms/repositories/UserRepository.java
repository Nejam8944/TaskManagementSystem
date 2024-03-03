package com.tms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.tms.DTO.UserDTO;
import com.tms.entities.User;
import com.tms.projection.UserProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "select username,email from user",nativeQuery = true)
	List<UserProjection> findUsersWithRequiredAttributes();
	
	@Query(value = "insert into user values( :userName, :email)",nativeQuery = true)
	void addUsersWithRequiredAttributes(@Param("userName") String userName, @Param("email") String email);
	
	List<User> findByEmailContainingIgnoreCase(@Param("domain") String domain);
	
	
	@Query("SELECT u " +
	           "FROM User u " +
	           "JOIN Task t ON u.id = t.user.id " +
	           "WHERE t.user.id IS NOT NULL " +
	           "GROUP BY u.id " +
	           "ORDER BY COUNT(t.id) DESC " +
	           "LIMIT 1")
	User findUserAssignedMostTask(); 
	
	 @Query("SELECT DISTINCT u " +
	           "FROM User u " +
	           "JOIN Task t ON u.id = t.user.id " +
	           "WHERE t.status = 'Completed'")
	List<User> findByCompletedtask();

}
