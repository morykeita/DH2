package com.dhub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dhub.beans.Status;
import com.dhub.util.HibernateUtil;

public class StatusDaoImpl implements StatusDao{

	public StatusDaoImpl() {
		
	}

	@Override
	public List<Status> getAllStatus() {
		Session session = HibernateUtil.getSession();
		List<Status> Statuss = session.createCriteria(Status.class).list();
		return Statuss;
	}

	@Override
	public void createStatus(Status s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
	}

	@Override
	public void updateStatus(Status s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(s);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteStatus(Status s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(s);
		tx.commit();
		session.close();
	}
}
