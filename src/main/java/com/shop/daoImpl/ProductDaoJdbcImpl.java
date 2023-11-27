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
	public void deleteProduct(Connection connection, int id) throws SQLException {
		String sql = "DELETE FROM product WHERE ProductID=?;";
		Object[] objects = {id};
		update(connection, sql, objects);
		
	}

	@Override
	public void updateProduct(Connection connection, Product product) throws SQLException {
		String sql = "UPDATE product SET ProductName=?, Price=?, StockQuantity=?, CategoryID=? WHERE ProductID=?;";
		Object[] objects = { product.getProductName(), product.getPrice(), product.getStockQuantity(), product.getCategoryID(), product.getProductID()};
		update(connection, sql, objects);
		
	}
	
	@Override
	public void updateProduct(Connection connection, int id) throws SQLException {
		String sql = "UPDATE product \r\n"
				+ "SET `Status` = CASE \r\n"
				+ "    WHEN `Status` = 1 THEN 0 \r\n"
				+ "    ELSE 1 \r\n"
				+ "END \r\n"
				+ "WHERE ProductID = ?;";
		Object[] objects = {id};
		update(connection, sql, objects);
		
	}

	@Override
	public Product searchProduct(Connection connection, Product product) throws SQLException {
		String sql = "SELECT * FROM product WHERE ProductName = ?;";
		Object[] objects = {product.getProductName()};
		return fetch(connection, sql, objects);
	}
	
	@Override
	public Product searchProduct(Connection connection, int id) throws SQLException {
		String sql = "SELECT * FROM product WHERE ProductID=?;";
		Object[] objects = {id};
		return fetch(connection, sql, objects);
	}

	@Override
	public List<Product> fetchAllProduct(Connection connection) throws SQLException {
		String sql = "SELECT p.ProductID, p.ProductName, p.Price, p.StockQuantity, p.CategoryID, c.CategoryName, p.Status\r\n"
				+ "FROM product p\r\n"
				+ "JOIN category c ON p.CategoryID = c.CategoryID;";
		return fetchList(connection, sql);
	}

}
