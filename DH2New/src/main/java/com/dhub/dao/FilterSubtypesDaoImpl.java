package com.dhub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dhub.util.HibernateUtil;

import com.dhub.beans.FilterSubtypes;

public class FilterSubtypesDaoImpl implements FilterSubtypesDao {

	public FilterSubtypesDaoImpl() {
		
	}

	@Override
	public List<FilterSubtypes> getAllFilterSubtypes() {
		Session session = HibernateUtil.getSession();
		List<FilterSubtypes> FilterSubtypes = session.createCriteria(FilterSubtypes.class).list();
		return FilterSubtypes;
	}

	@Override
	public void createFilterSubtype(FilterSubtypes fs) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(fs);
		tx.commit();
		session.close();
	}

	@Override
	public void updateFilterSubtype(FilterSubtypes fs) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(fs);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteFilterSubtype(FilterSubtypes fs) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(fs);
		tx.commit();
		session.close();
	}
}
