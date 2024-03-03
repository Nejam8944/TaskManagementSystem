package com.tms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"USER\"")
public class User {

	@Id
	private int userID;
	private String userName;
	private String password;
	private String email;
	private String fullName;
}
