package com.dhub.dao;

import java.util.List;

import com.dhub.beans.Products;

public interface ProductsDao {
	public List<Products> getAllProducts();
	public void createProduct(Products p);
	public void updateProduct(Products p);
	public void deleteProduct(Products p);
}
