package com.dhub.dao;

import java.util.List;

import com.dhub.beans.Roles;

public interface RolesDao {
	public List<Roles> getAllRoles();
	public void createRole(Roles r);
	public void updateRole(Roles r);
	public void deleteRole(Roles r);
}
