package com.dhub.dao;

import java.util.List;

import com.dhub.beans.Status;

public interface StatusDao {
	public List<Status> getAllStatus();
	public void createStatus(Status s);
	public void updateStatus(Status s);
	public void deleteStatus(Status s);
}
