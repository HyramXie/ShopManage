package com.shop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.Product;

public interface ProductDao {
	public void addProduct(Connection connection, Product product) throws SQLException;

	public void deleteProduct(Connection connection, int id) throws SQLException;
	
	public void updateProduct(Connection connection, Product product) throws SQLException;
	
	public void updateProduct(Connection connection, int id) throws SQLException;
	
	public void updateProduct(Connection connection, int id, int quantity) throws SQLException;

	public Product searchProduct(Connection connection, Product product) throws SQLException;
	
	public Product searchProduct(Connection connection, int id) throws SQLException;
	
	public List<Product> fetchAllProduct(Connection connection) throws SQLException;
}
