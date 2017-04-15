package com.dhub.dao;

import java.util.List;

import com.dhub.beans.Users;

public interface UsersDao {
	public void createUser(Users u);
	public void updateUser(Users u);
	public void deleteUser(Users u);
	public List<Users> getAllUsers();
	public Users getCredentials(String username);
	public Users getUserInfo(Integer userId);
}
