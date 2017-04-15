package com.dhub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dhub.util.HibernateUtil;

import com.dhub.beans.Filters;

public class FiltersDaoImpl implements FiltersDao {

public FiltersDaoImpl() {
		
	}

	@Override
	public List<Filters> getAllFilters() {
		Session session = HibernateUtil.getSession();
		List<Filters> Filters = session.createCriteria(Filters.class).list();
		return Filters;
	}

	@Override
	public void createFilter(Filters f) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(f);
		tx.commit();
		session.close();
	}

	@Override
	public void updateFilter(Filters f) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(f);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteFilter(Filters f) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(f);
		tx.commit();
		session.close();
	}

}
