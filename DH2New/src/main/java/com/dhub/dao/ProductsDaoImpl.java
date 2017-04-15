package com.dhub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dhub.beans.Products;
import com.dhub.util.HibernateUtil;

public class ProductsDaoImpl implements ProductsDao{
	@Override
	public List<Products> getAllProducts() {
		Session session = HibernateUtil.getSession();
		List<Products> Products = session.createCriteria(Products.class).list();
		return Products;
	}

	@Override
	public void createProduct(Products p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}

	@Override
	public void updateProduct(Products p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(p);
		tx.commit();
		session.close();
	}
	
	@Override
	public void deleteProduct(Products p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
		session.close();
	}
}
