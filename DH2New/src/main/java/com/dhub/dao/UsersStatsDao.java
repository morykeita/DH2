package com.dhub.dao;

import java.util.List;

import com.dhub.beans.UserStats;

public interface UsersStatsDao {
	public List<UserStats> getAllUserStats();
	public void createUserStat(UserStats us);
	public void updateUserStat(UserStats us);
	public void deleteUserStat(UserStats us);
}
