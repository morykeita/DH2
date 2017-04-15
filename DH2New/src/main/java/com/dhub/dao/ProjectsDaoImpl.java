package com.dhub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dhub.beans.Projects;
import com.dhub.util.HibernateUtil;

public class ProjectsDaoImpl implements ProjectsDao{

	public ProjectsDaoImpl() {
		
	}

	@Override
	public List<Projects> getAllProjects() {
		Session session = HibernateUtil.getSession();
		List<Projects> Projects = session.createCriteria(Projects.class).list();
		return Projects;
	}

	@Override
	public void createProject(Projects p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}

	@Override
	public void updateProject(Projects p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(p);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteProject(Projects p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
		session.close();
	}
}
