package com.shop.daoImpl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.Product;
import com.shop.dao.ProductDao;

public class ProductDaoJdbcImpl extends DaoJdbcImpl<Product> implements ProductDao{


	@Override
	public void addProduct(Connection connection, Product product) throws SQLException {
		String sql = "INSERT INTO product (ProductName, Price, StockQuantity, CategoryID) VALUES (?, ?, ?, ?);";
		Object[] objects = {product.getProductName(), product.getPrice(), product.getStockQuantity(), product.getCategoryID()};
		update(connection, sql, objects);
	}

	@Override
	public void deleteProduct(Connection connection, String name) throws SQLException {
//		String sql = "DELETE FROM user WHERE name = ?;";
//		Object[] objects = {name};
//		update(connection, sql, objects);
		
	}

	@Override
	public void updateProduct(Connection connection, Product product) throws SQLException {
//		String sql = "UPDATE user SET password = ?	WHERE name = ?;";
//		Object[] objects = { user.getPassword(), user.getUsername()};
//		update(connection, sql, objects);
		
	}

	@Override
	public Product searchProduct(Connection connection, Product product) throws SQLException {
		String sql = "SELECT * FROM category WHERE ProductName = ?;";
		Object[] objects = {product.getProductName()};
		return fetch(connection, sql, objects);
	}

	@Override
	public List<Product> fetchAllProduct(Connection connection) throws SQLException {
		String sql = "SELECT * FROM product";
		return fetchList(connection, sql);
	}

}
