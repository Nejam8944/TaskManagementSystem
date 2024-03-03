package com.tms.id;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode
@Embeddable
public class UserRolesId implements Serializable{

	private int userID;
	private int userRoleID;
}
