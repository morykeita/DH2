package com.dhub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dhub.util.HibernateUtil;

import com.dhub.beans.Meetings;

public class MeetingsDaoImpl implements MeetingsDao {

	public MeetingsDaoImpl() {
		
	}

	@Override
	public List<Meetings> getAllMeetings() {
		Session session = HibernateUtil.getSession();
		List<Meetings> Meetings = session.createCriteria(Meetings.class).list();
		return Meetings;
	}

	@Override
	public void createMeeting(Meetings m) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(m);
		tx.commit();
		session.close();
	}

	@Override
	public void updateMeeting(Meetings m) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(m);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteMeeting(Meetings m) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(m);
		tx.commit();
		session.close();
	}
}
