package com.dhub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dhub.beans.UserStats;
import com.dhub.util.HibernateUtil;

public class UsersStatsDaoImpl implements UsersStatsDao {
	public UsersStatsDaoImpl() {
		
	}

	@Override
	public List<UserStats> getAllUserStats() {
		Session session = HibernateUtil.getSession();
		List<UserStats> UserStats = session.createCriteria(UserStats.class).list();
		return UserStats;
	}

	@Override
	public void createUserStat(UserStats us) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(us);
		tx.commit();
		session.close();
	}

	@Override
	public void updateUserStat(UserStats us) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(us);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteUserStat(UserStats us) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(us);
		tx.commit();
		session.close();
	}
}
