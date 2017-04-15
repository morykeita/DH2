package com.dhub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dhub.beans.Roles;
import com.dhub.util.HibernateUtil;

public class RolesDaoImpl implements RolesDao {

	public RolesDaoImpl() {
		
	}

	@Override
	public List<Roles> getAllRoles() {
		Session session = HibernateUtil.getSession();
		List<Roles> roles = session.createCriteria(Roles.class).list();
		return roles;
	}

	@Override
	public void createRole(Roles r) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(r);
		tx.commit();
		session.close();
	}

	@Override
	public void updateRole(Roles r) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(r);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteRole(Roles r) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(r);
		tx.commit();
		session.close();
	}
}
