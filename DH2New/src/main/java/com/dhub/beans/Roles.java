package com.dhub.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ROLES")
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -982069070257648734L;

	@Id
	@Column(name="ROLE_ID")	
	@SequenceGenerator(name="ROLE_SEQ", sequenceName="ROLE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_SEQ")
	private Integer roleId;
	
	@Column(name="ROLE")
	private String role;
	
	public Roles() {
		
	}	
	
	public Roles(String role) {
		super();
		this.role = role;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", role=" + role + "]";
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	
}
