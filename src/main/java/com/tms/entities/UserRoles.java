package com.tms.entities;

import com.tms.id.UserRolesId;

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
public class UserRoles {

	@EmbeddedId
	private UserRolesId id;
	
	@ManyToOne
	@JoinColumn(name = "userID" , insertable=false, updatable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "userRoleID", insertable=false, updatable=false)
	private UserRole userRole;
}
