package com.dhub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.dhub.beans.Users;
import com.dhub.util.HibernateUtil;

@Component
public class UsersDaoImpl implements UsersDao {

	public UsersDaoImpl()  {
		
	}

	@Override
	public List<Users> getAllUsers() {
		Session session = HibernateUtil.getSession();
		List<Users> users = session.createCriteria(Users.class).list();
		return users;
	}

	@Override
	public Users getCredentials(String uname) {
		Session session = HibernateUtil.getSession();
		String hql = "FROM Users WHERE userName=:val";
		Query q = session.createQuery(hql);
		q.setParameter("val", uname);
		List<Users> userList = q.list();
		if (userList.isEmpty()){
			return null;
		}
		Users user = userList.get(0);
		return user;
	}
	
	@Override
	public Users getUserInfo(Integer uid){
		Session session = HibernateUtil.getSession();
		String hql = "FROM Users WHERE userId=:val";
		Query q = session.createQuery(hql);
		q.setParameter("val", uid);
		List<Users> userList = q.list();
		if (userList.isEmpty()){
			return null;
		}
		Users user = userList.get(0);
		return user;
	}

	@Override
	public void createUser(Users u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}

	@Override
	public void updateUser(Users u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.merge(u);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteUser(Users u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(u);
		tx.commit();
		session.close();
	}
}
