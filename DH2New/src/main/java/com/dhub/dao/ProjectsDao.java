package com.dhub.dao;

import java.util.List;

import com.dhub.beans.Projects;

public interface ProjectsDao {
	public List<Projects> getAllProjects();
	public void createProject(Projects p);
	public void updateProject(Projects p);
	public void deleteProject(Projects p);
}
